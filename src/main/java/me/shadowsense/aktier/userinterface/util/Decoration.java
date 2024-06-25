package me.shadowsense.aktier.userinterface.util;

import me.abdiskiosk.guis.gui.GUI;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.ItemBuilder;
import me.abdiskiosk.guis.item.PaneColor;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Decoration {
    public static void setDecoration(GUI gui, PaneColor color1, PaneColor color2) {
        int size = gui.getSizeSlots();

        Collection<Integer> top = IntStream.range(0, 9).boxed().collect(Collectors.toList());
        Collection<Integer> bottom = IntStream.range(size - 9, size).boxed().collect(Collectors.toList());

        gui.set(new GUIItem(top, ItemBuilder.pane(color1).build()));
        gui.set(new GUIItem(bottom, ItemBuilder.pane(color2).build()));
    }
}
