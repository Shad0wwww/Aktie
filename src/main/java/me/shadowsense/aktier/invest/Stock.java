package me.shadowsense.aktier.invest;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class Stock {

    private String name;
    private BigDecimal price;
    private List<String> description;
    private Risk risk;

    public Stock(String name, BigDecimal price, List<String> description, Risk risk) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.risk = risk;
    }
}
