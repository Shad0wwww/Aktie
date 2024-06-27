package me.shadowsense.aktier.userinterface.guis.home;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;

import me.abdiskiosk.guis.item.PaneColor;
import me.shadowsense.aktier.userinterface.AktieGUI;
import me.shadowsense.aktier.userinterface.guis.stocklist.StockList;
import me.shadowsense.aktier.userinterface.util.Button;
import org.bukkit.entity.Player;

@Component
public class Home {

    private @Inject StockList stockList;

    public void open(Player player) {
        new GUI(player).open(player);
    }

    public class GUI extends AktieGUI<HomeConfig>{

        public GUI(Player player) {
            super(PaneColor.CYAN, PaneColor.WHITE, new HomeConfig());
            Button.setClose(this, 36);
            setItems();

        }
    }


}
