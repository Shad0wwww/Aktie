package me.shadowsense.aktier.utils;

import eu.okaeri.placeholders.Placeholders;
import eu.okaeri.placeholders.context.Placeholder;
import me.shadowsense.aktier.invest.Risk;
import me.shadowsense.aktier.invest.Stock;

public class PlaceholderResolvers {

    public void registerPlaceholderResolvers(Placeholders placeholders) {

        placeholders.registerPlaceholder(Stock.class, "stock.name", (stock, ___, ____) -> stock.getName());
        placeholders.registerPlaceholder(Stock.class, "stock.price", (stock, ___, ____) -> String.valueOf(stock.getPrice()));
        placeholders.registerPlaceholder(Stock.class, "stock.risk", (stock, ___, ____) -> Risk.valueOf(String.valueOf(stock.getRisk())));
        placeholders.registerPlaceholder(Stock.class, "stock.description", (stock, ___, ____) -> String.join("\n", stock.getDescription()));
    }
}
