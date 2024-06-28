package me.shadowsense.aktier.userinterface.serdes.item;

import eu.okaeri.configs.OkaeriConfig;
import lombok.Getter;
import me.abdiskiosk.guis.item.GUIItem;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
public class ConfigItem extends OkaeriConfig {
    private List<Integer> slots;
    private ItemStack item;

    public ConfigItem(List<Integer> slots, ItemStack item) {
        this.slots = slots;
        this.item = item;
    }

    public GUIItem toGuiItem() {
        return new GUIItem(slots, item);
    }
}
