package me.shadowsense.aktier.config;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
import me.shadowsense.aktier.invest.InvestCreate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
@Configuration(path = "stock.yml", provider = YamlSnakeYamlConfigurer.class)
public class Stock extends OkaeriConfig {

    public Stock() {
        List<String> description = Arrays.asList("Google is a technology company that specializes in Internet-related services and products,",
                "which include online advertising technologies, a search engine, cloud computing, software, and hardware.");

        String name = "Google";

        BigDecimal price = new BigDecimal("1000.00");

    }
}
