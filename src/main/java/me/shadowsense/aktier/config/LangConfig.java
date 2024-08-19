package me.shadowsense.aktier.config;

import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.i18n.configs.LocaleConfig;
import eu.okaeri.platform.core.annotation.Messages;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@SuppressWarnings("FieldMayBeFinal")
@Messages(defaultLocale = "dk", provider = YamlSnakeYamlConfigurer.class)
public class LangConfig extends LocaleConfig {
    private String reloadStart = "&8&l[ &6&lAktier &8&l] &7Genindlæser...";
    private String reloadEnd = "&8&l[ &6&lAktier &8&l] &aDu genindlæste pluginnet successfuldt! &2({ms}ms)";
    private String stockPricesUpdated = "&8&l[ &6&lAktier &8&l] &aAktiepriserne er blevet opdateret!";

    @Comment("Command messages")
    private String noPermission = "&8&l[ &6&lAktier &8&l] &cDu har ikke tilladelse til at udføre denne kommando!";
    private String addedStock = "&8&l[ &6&lAktier &8&l] &aDu har tilføjet {stock_name} til aktier!";
    private String stockAllreadyExists = "&8&l[ &6&lAktier &8&l] &c{stock_name} eksisterer allerede!";
    private String invalidPrice = "&8&l[ &6&lAktier &8&l] &cPrisen skal være et nummer!";

}
