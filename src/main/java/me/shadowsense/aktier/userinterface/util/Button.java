package me.shadowsense.aktier.userinterface.util;

import me.abdiskiosk.guis.gui.GUI;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Button {

    public static void setClose(GUI gui, int slot) {
        gui.set(new GUIItem(slot,
                new ItemBuilder(new ItemStack(Material.INK_SACK, 1, (short) 1))
                        .setName("§fLuk menu.")
                        .build()
        )).onClick(event -> event.getWhoClicked().closeInventory());
    }

    public static void setBack(GUI gui, int slot, Runnable runnable) {
        gui.set(new GUIItem(slot,
                new ItemBuilder(new ItemStack(Material.INK_SACK, 1, (short) 1))
                        .setName("§fTilbage.")
                        .build()
        )).onClick(event -> runnable.run());
    }
}
