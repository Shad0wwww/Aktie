package me.shadowsense.aktier.config;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.Comments;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
import me.shadowsense.aktier.invest.Risk;


@Getter @Setter
@Configuration(path = "config.yml", provider = YamlSnakeYamlConfigurer.class)
public class Config extends OkaeriConfig {

    @Comment({
            "The interval in seconds between each stock update",
            "Default: 10",
            "the time is in minutes, so 10 is 10 minutes, 60 is 1 hour, 1440 is 1 day, etc."
    })
    private Integer updateInterval = 10;


    @Comment({
            "The procent for the Low risk stock",
            "Default: 5%",
    })
    private int lowStockProcent  = 5;

    @Comment({
            "The procent for the Medium risk stock",
            "Default: 10%",
    })

    private int mediumStockProcent = 10;

    @Comment({
            "The procent for the High risk stock",
            "Default: 20%",
    })

    private int highStockProcent  = 20;
}
