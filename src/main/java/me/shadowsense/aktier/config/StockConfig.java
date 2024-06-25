package me.shadowsense.aktier.config;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.platform.core.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
import me.shadowsense.aktier.config.serdes.StockSerdes;
import me.shadowsense.aktier.invest.Risk;
import me.shadowsense.aktier.invest.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
@Configuration(path = "stock.yml", provider = YamlSnakeYamlConfigurer.class, serdes = StockSerdes.class)
public class StockConfig extends OkaeriConfig {

    private List<Stock> stocks = new ArrayList<>();

    public StockConfig() {
        List<String> description = Arrays.asList(
                "&f",
                "&fGoogle is a technology company that specializes in Internet-related services and products,",
                "&fwhich include online advertising technologies,",
                "&fa search engine, cloud computing, software, and hardware."
        );


        String name = "&4&LGOOGLE";

        BigDecimal price = new BigDecimal("1000.00");

        Risk risk = Risk.MEDIUM;

        Stock stock = new Stock(name, price, description, risk);

        this.stocks.add(stock);

    }
}
