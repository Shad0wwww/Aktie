package me.shadowsense.aktier.cmd;

import eu.okaeri.commands.annotation.Command;
import eu.okaeri.commands.annotation.Context;
import eu.okaeri.commands.annotation.Executor;
import eu.okaeri.commands.bukkit.annotation.Permission;
import eu.okaeri.commands.bukkit.annotation.Sync;
import eu.okaeri.commands.service.CommandService;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.bukkit.i18n.BI18n;
import me.shadowsense.aktier.config.Config;
import me.shadowsense.aktier.config.LangConfig;
import me.shadowsense.aktier.config.StockConfig;
import me.shadowsense.aktier.invest.StockManager;
import me.shadowsense.aktier.userinterface.guis.home.Home;
import me.shadowsense.aktier.userinterface.guis.home.HomeConfig;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(label = "aktie", aliases = {"stock", "stocks"})
@Permission("aktier.cmd.aktie")
public class Aktie implements CommandService {

    private @Inject Home home;
    private @Inject StockConfig stockConfig;
    private @Inject BI18n i18n;
    private @Inject LangConfig langConfig;
    private @Inject Config config;
    private @Inject StockManager stockManager;
    private @Inject HomeConfig homeConfig;


    @Executor
    public void __(@Context CommandSender sender) {
        Player player = (Player) sender;
        home.open(player);

    }

    @Executor @Sync
    public void reload(CommandSender sender) {
        Player player = (Player) sender;

        long ms = System.currentTimeMillis();

        i18n.get(langConfig.getReloadStart()).sendTo(player);
        i18n.load();
        config.load();
        stockConfig.load();
        homeConfig.load();
        stockManager.load();
        i18n.get(langConfig.getReloadEnd())
            .with("ms", System.currentTimeMillis() - ms)
            .sendTo(player);

    }



}
