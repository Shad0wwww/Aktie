package me.shadowsense.aktier.config;

import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.i18n.configs.LocaleConfig;
import eu.okaeri.platform.core.annotation.Messages;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SuppressWarnings("FieldMayBeFinal")
@Messages(defaultLocale = "dk", provider = YamlSnakeYamlConfigurer.class)
public class LangConfig extends LocaleConfig {
    private String reloadStart = "&8&l[ &6&lAktier &8&l] &7Genindlæser...";
    private String reloadEnd = "&8&l[ &6&lAktier &8&l] &aDu genindlæste pluginnet successfuldt! &2({ms}ms)";
}
