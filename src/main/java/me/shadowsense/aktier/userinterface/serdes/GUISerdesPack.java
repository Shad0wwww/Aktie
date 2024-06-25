package me.shadowsense.aktier.userinterface.serdes;


import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import eu.okaeri.configs.serdes.SerdesRegistry;
import lombok.NonNull;
import me.shadowsense.aktier.userinterface.serdes.config.ItemStackSerializer;
import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;
import me.shadowsense.aktier.userinterface.serdes.item.GUIItemSerializer;
import org.bukkit.inventory.ItemStack;

public class GUISerdesPack implements OkaeriSerdesPack {
    @Override
    public void register(@NonNull SerdesRegistry registry) {
        registry.registerExclusive(ItemStack.class, new ItemStackSerializer());
        registry.registerExclusive(ConfigItem.class, new GUIItemSerializer());
    }
}