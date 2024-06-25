package me.shadowsense.aktier.userinterface.guis.home;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;

import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.item.PaneColor;
import me.shadowsense.aktier.userinterface.AktieGUI;
import me.shadowsense.aktier.userinterface.guis.StockList;
import me.shadowsense.aktier.userinterface.util.Button;
import org.bukkit.Material;
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
            //setItem(getConfig().getItem().getSlots().get(0), getConfig().getItem().getItem())



        }
    }


}
