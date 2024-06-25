package me.shadowsense.aktier.config.serdes;

import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import eu.okaeri.configs.serdes.SerdesRegistry;
import lombok.NonNull;
import me.shadowsense.aktier.invest.Stock;
import org.bukkit.inventory.ItemStack;

public class StockSerdes implements OkaeriSerdesPack {
    @Override
    public void register(@NonNull SerdesRegistry registry) {
        registry.register(new StockSerializer());
    }
}
