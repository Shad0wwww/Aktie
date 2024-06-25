package me.shadowsense.aktier.config.serdes;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;
import me.shadowsense.aktier.invest.Risk;
import me.shadowsense.aktier.invest.Stock;

import java.math.BigDecimal;
import java.util.List;

public class StockSerializer implements ObjectSerializer<Stock> {
    @Override
    public boolean supports(@NonNull Class<? super Stock> type) {
        return type.equals(Stock.class);
    }

    @Override
    public void serialize(@NonNull Stock object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
        data.add("name", object.getName());
        data.add("price", object.getPrice());
        data.add("description", object.getDescription());
        data.add("risk", object.getRisk());
    }

    @Override
    public Stock deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
        String name = data.get("name", String.class);
        BigDecimal price = data.get("price", BigDecimal.class);
        List<String> description = data.getAsList("description", String.class);
        Risk risk = data.get("risk", Risk.class);

        return new Stock(name, price, description, risk);
    }
}
