package me.shadowsense.aktier.userinterface.guis.stocklist;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.placeholders.context.Placeholder;
import eu.okaeri.platform.core.annotation.Component;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.item.PaneColor;
import me.abdiskiosk.guis.util.Placeholders;
import me.shadowsense.aktier.config.StockConfig;
import me.shadowsense.aktier.invest.Stock;
import me.shadowsense.aktier.invest.StockManager;
import me.shadowsense.aktier.userinterface.AktieGUI;
import me.shadowsense.aktier.userinterface.guis.home.Home;
import me.shadowsense.aktier.userinterface.util.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Component
public class StockList {

    private @Inject StockManager stockManager;

    public void open(Player player) {
        new GUI(player).open(player);
    }

    public class GUI extends AktieGUI<StockListConfig> {


        public GUI(Player player) {
            super(new StockListConfig());
            Button.setBack(this, 36, () -> new Home().open(player));
            setStocksList();

        }

        private void setStocksList() {
            int i = 9;
            for (Stock stock : stockManager.getStocks()) {
                setItem(i, getConfig().getStockItem().getItem(), stock);
                i++;
            }
        }


    }


}
