package me.shadowsense.aktier.utils;

import eu.okaeri.placeholders.Placeholders;
import me.shadowsense.aktier.invest.Risk;
import me.shadowsense.aktier.invest.objects.Stock;

public class PlaceholderResolvers {

    public void registerPlaceholderResolvers(Placeholders placeholders) {

        placeholders.registerPlaceholder(Stock.class, "name", (stock, ___, ____) -> stock.getName());
        placeholders.registerPlaceholder(Stock.class, "price", (stock, ___, ____) -> String.valueOf(stock.getPrice()));
        placeholders.registerPlaceholder(Stock.class, "risk", (stock, ___, ____) -> Risk.valueOf(String.valueOf(stock.getRisk())));
    }
}
