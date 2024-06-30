package me.shadowsense.aktier.userinterface.guis.home;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;

import me.abdiskiosk.guis.item.GUIItem;
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
            super(new HomeConfig());
            Button.setClose(this, 36);
            System.out.println("Player: " + player.getName());

            set(getConfig().item.toGuiItem()).onClick(event -> stockList.open(player));

        }
    }


}
