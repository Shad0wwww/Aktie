package me.shadowsense.aktier.userinterface.guis;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;
import me.abdiskiosk.guis.config.item.ConfigItem;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.item.PaneColor;
import me.shadowsense.aktier.config.StockConfig;
import me.shadowsense.aktier.invest.Stock;
import me.shadowsense.aktier.invest.StockManager;
import me.shadowsense.aktier.userinterface.AktieGUI;
import me.shadowsense.aktier.userinterface.util.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Component
public class StockList {


    private @Inject StockManager stockManager;
    private @Inject StockConfig stockConfig;

    public void open(Player player) {
        new GUI(player).open(player);
    }

    public class GUI extends AktieGUI {


        public GUI(Player player) {
            super("§8§l[ §b§lSTOCK §7- §f§lLIST §8§l]", 45, PaneColor.CYAN, PaneColor.WHITE);

            setStocksList();
        }

        private void setStocksList() {
            int i = 9;
            for (Stock stock : stockManager.getStocks()) {
                createStockItem(stock, i);
                i++;
            }
        }

        private void createStockItem(Stock stock, int slot) {
            String[] lore = stock.getDescription()
                    .stream()
                    .map(s -> s.replace("&", "§"))
                    .toArray(String[]::new);

            String name = stock.getName().replaceAll("&", "§");

            ItemBuilder itemBuilder = new ItemBuilder(Material.PAPER)
                    .setName(name)
                    .setLore(lore)
                    .addLore("§f", "§fPris: §a" + stock.getPrice() + " kr", "§fRisk: §a" + stock.getRisk());

            GUIItem item = new GUIItem(slot, itemBuilder
                    .build());




        }

    }


}
