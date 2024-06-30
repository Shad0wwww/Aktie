package me.shadowsense.aktier.userinterface.guis.home;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.item.PaneColor;
import me.shadowsense.aktier.userinterface.serdes.ConfigCompliance;
import me.shadowsense.aktier.userinterface.serdes.GUISerdesPack;
import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;

import java.util.Collections;
import java.util.List;
@Getter
@Configuration(path = "guis/home.yml", provider = YamlSnakeYamlConfigurer.class, serdes = GUISerdesPack.class)
public class HomeConfig extends OkaeriConfig implements ConfigCompliance {

    @Comment("The title of the GUI")
    private String title = "§8§l[ §b§lSTOCK §7- §f§lHOME §8§l]";

    @Comment("The size of the GUI")
    private Integer SlotSize = 45;

    @Comment("The color of the top pane")
    private PaneColor TopPaneColor = PaneColor.CYAN;
    @Comment("The color of the bottom pane")
    private PaneColor BottomPaneColor = PaneColor.WHITE;


    @Comment("The item that opens the stock list")
    public ConfigItem item = new ConfigItem(
            Collections.singletonList(20), ItemBuilder.skull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM0ZTQ0MWVhYzg4NGRlMzM0N2E4Nzc1YTA3YTY2YmJjNGM4MmEyNGVkMmQwY2ZlYjFhY2FmNmNlOTlkNTNiNiJ9fX0=")
            .setLore("§fKlik her for at se alle aktier")
            .setName("§aAktier")
            .build());



    @Override
    public List<ConfigItem> getItems() {
        return Collections.singletonList(item);
    }
}
