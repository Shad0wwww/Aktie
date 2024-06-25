package me.shadowsense.aktier.userinterface.guis;

import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;

import eu.okaeri.platform.core.annotation.Configuration;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.item.PaneColor;
import me.shadowsense.aktier.userinterface.AktieGUI;
import me.shadowsense.aktier.userinterface.serdes.GUISerdesPack;
import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;
import me.shadowsense.aktier.userinterface.util.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Collections;

@Component
public class Home {

    private @Inject StockList stockList;

    public void open(Player player) {
        new GUI(player).open(player);
    }


    public class GUI extends AktieGUI {

        public GUI(Player player) {
            super("§8§l[ §b§lSTOCK §7- §f§lHOME §8§l]", 45, PaneColor.CYAN, PaneColor.WHITE);
            Button.setClose(this, 36);

            ItemBuilder itemBuilder = new ItemBuilder(Material.PAPER)
                    .setName("§aAktier")
                    .setLore("§fKlik her for at se alle aktier");

            GUIItem item = new GUIItem(20, itemBuilder.build());

            set(item).onClick(e -> stockList.open(player));


        }
    }


}
