package me.shadowsense.aktier.userinterface.guis.stocklist;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.placeholders.context.Placeholder;
import eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.util.Placeholders;
import me.shadowsense.aktier.invest.StockManager;
import me.shadowsense.aktier.userinterface.serdes.ConfigCompliance;
import me.shadowsense.aktier.userinterface.serdes.GUISerdesPack;
import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;
import org.bukkit.Material;

import java.util.Collections;
import java.util.List;

@Getter
@Configuration(path = "guis/stockList.yml", provider = YamlSnakeYamlConfigurer.class, serdes = GUISerdesPack.class)
public class StockListConfig extends OkaeriConfig implements ConfigCompliance {

    @Comment("The title of the GUI")
    private String title = "§8§l[ §b§lSTOCK §7- §f§lLIST §8§l]";

    @Comment("The size of the GUI")
    private Integer SlotSize = 45;

    @Comment("")
    public ConfigItem stockItem = new ConfigItem(
            Collections.emptyList(), ItemBuilder.skull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE2ZDYxZjQ1M2MwMTU5ZWU3Y2Q4MWE0YzNlMDUzZTlkYTdkYzE0ODYzMTg4OTBhZDRhZDlhY2Y2MTE5NmI4NSJ9fX0=")
            .setName("&a{stock.name}")
            .setLore(
                    "",
                    "&fKlik her for at se alle aktier",
                    "",
                    "&fVærdi: {stock.price} kr",
                    "&fRist: {stock.risk}",
                    "&f{stock.description}",
                    ""
            )
            .build());


    @Override
    public List<ConfigItem> getItems() {
        return Collections.singletonList(stockItem);
    }
}
