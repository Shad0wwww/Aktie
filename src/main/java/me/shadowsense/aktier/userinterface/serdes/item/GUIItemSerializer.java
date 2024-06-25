package me.shadowsense.aktier.userinterface.serdes.item;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import lombok.NonNull;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class GUIItemSerializer implements ObjectSerializer<ConfigItem> {

    @Override
    public boolean supports(@NonNull Class<? super ConfigItem> type) {
        return type.equals(ConfigItem.class);
    }

    @Override
    public void serialize(@NonNull ConfigItem object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics) {
        data.add("item", object.getItem());
        data.add("slots", object.getSlots());
    }

    @Override
    @SuppressWarnings("unchecked")
    public ConfigItem deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics) {
        ItemStack item = data.get("item", ItemStack.class);
        List<Integer> slots;
        try {
            slots = (List<Integer>) data.get("slots", ArrayList.class);
        } catch(ClassCastException ex) {
            throw new IllegalArgumentException("Invalid slots type: " + data.get("slots", Object.class).toString());
        }
        return new ConfigItem(slots, item);
    }
}
