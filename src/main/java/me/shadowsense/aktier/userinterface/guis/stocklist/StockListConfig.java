package me.shadowsense.aktier.userinterface.guis.stocklist;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.shadowsense.aktier.userinterface.serdes.ConfigCompliance;
import me.shadowsense.aktier.userinterface.serdes.GUISerdesPack;
import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;
import org.bukkit.Material;

import java.util.Collections;
import java.util.List;

@Getter
@Configuration(path = "guis/stockList.yml", provider = YamlSnakeYamlConfigurer.class, serdes = GUISerdesPack.class)
public class StockListConfig extends OkaeriConfig implements ConfigCompliance {
    @Override
    public String getTitle() {
        return "§8§l[ §b§lSTOCK §7- §f§lLIST §8§l]";
    }

    @Override
    public Integer getSlotSize() {
        return 45;
    }

    public ConfigItem stockItem = new ConfigItem(
            Collections.emptyList(), new ItemBuilder(Material.PAPER)
            .setName("§a{stock.name}")
            .setLore(
                    "",
                    "§fKlik her for at se alle aktier",
                    "{stock.price}",
                    "{stock.risk}",
                    "{stock.description}"
            )
            .build());
    @Override
    public List<ConfigItem> getItems() {
        return Collections.singletonList(stockItem);
    }
}
