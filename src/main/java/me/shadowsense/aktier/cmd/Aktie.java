package me.shadowsense.aktier.cmd;

import eu.okaeri.commands.annotation.Arg;
import eu.okaeri.commands.annotation.Command;
import eu.okaeri.commands.annotation.Context;
import eu.okaeri.commands.annotation.Executor;
import eu.okaeri.commands.bukkit.annotation.Async;
import eu.okaeri.commands.bukkit.annotation.Permission;
import eu.okaeri.commands.bukkit.annotation.Sync;
import eu.okaeri.commands.service.CommandService;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.bukkit.i18n.BI18n;
import me.shadowsense.aktier.config.Config;
import me.shadowsense.aktier.config.LangConfig;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.Risk;
import me.shadowsense.aktier.invest.objects.Stock;
import me.shadowsense.aktier.invest.StockManager;
import me.shadowsense.aktier.invest.objects.StockUser;
import me.shadowsense.aktier.userinterface.guis.home.Home;
import me.shadowsense.aktier.userinterface.guis.home.HomeConfig;
import me.shadowsense.aktier.userinterface.guis.stocklist.StockListConfig;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

@Command(label = "aktie", aliases = {"stock", "stocks"})
public class Aktie implements CommandService {
    //LANG
    private @Inject Home home;
    private @Inject BI18n i18n;
    private @Inject LangConfig langConfig;
    private @Inject Config config;
    private @Inject StockManager stockManager;
    private @Inject HomeConfig homeConfig;
    private @Inject StockListConfig stockListConfig;
    //STORE
    private @Inject StoreManager storeManager;


    @Executor @Async
    public void __(@Context CommandSender sender) {
        Player player = (Player) sender;
        if (!storeManager.getUserStore().get(player.getUniqueId()).isPresent()) {
            storeManager.getUserStore().create(player.getUniqueId());
        }
        home.open(player);
    }

    //ADMIN COMMANDS
    @Executor @Sync
    @Permission("aktier.cmd.reload")
    public void reload(@Context CommandSender sender) {
        Player player = (Player) sender;
        long ms = System.currentTimeMillis();
        i18n.get(langConfig.getReloadStart()).sendTo(player);
        i18n.load();
        config.load();
        homeConfig.load();
        stockListConfig.load();
        i18n.get(langConfig.getReloadEnd())
                .with("ms", System.currentTimeMillis() - ms)
                .sendTo(player);

    }

    @Async
    @Executor
    public void addStock(@Context Player player, @Arg String name, @Arg Risk risk, @Arg String price) {

        if (storeManager.getStockStore().exists(name.toLowerCase())) {
            i18n.get(langConfig.getStockAllreadyExists())
                .with("stock_name", name.toLowerCase())
                .sendTo(player);
            return;
        }

        try {
            BigDecimal priceValue = new BigDecimal(price);
            Stock stock = new Stock(name, priceValue, risk, storeManager.getStockStore().getAll().size()+1);
            storeManager.getStockStore().update(stock);

            i18n.get(langConfig.getAddedStock())
                .with("stock_name", name)
                .sendTo(player);

        } catch (NumberFormatException e) {
            i18n.get(langConfig.getInvalidPrice())
                    .sendTo(player);

            throw new RuntimeException("Invalid price: Executed by" + player.getDisplayName(), e);
        }
    }





}
