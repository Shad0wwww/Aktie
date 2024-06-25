package me.shadowsense.aktier.userinterface;

import eu.okaeri.placeholders.context.Placeholder;
import lombok.Getter;
import me.abdiskiosk.guis.gui.AutoUpdatingGUI;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.PaneColor;
import me.abdiskiosk.guis.reflection.StateFinder;
import me.abdiskiosk.guis.state.StaticNamedState;
import me.shadowsense.aktier.userinterface.serdes.ConfigCompliance;
import me.shadowsense.aktier.userinterface.util.Decoration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.function.Consumer;

public class AktieGUI<C extends ConfigCompliance>extends AutoUpdatingGUI {

    protected final PaneColor color1;
    protected final PaneColor color2;
    @Getter
    protected final C config;
    public AktieGUI(PaneColor color1, PaneColor color2, C config) {
        super(config.getTitle(), config.getSlotSize());
        this.color1 = color1;
        this.color2 = color2;
        this.config = config;

        setDecoration();
    }

    public AktieGUI(String name, int sizeSlots, PaneColor color1, PaneColor color2) {
        super(name, sizeSlots);
        this.color1 = color1;
        this.color2 = color2;
        this.config = null;
        setDecoration();
    }

    protected void setItems() {
        config.getItems().forEach(item -> set(new GUIItem(item.getSlots(), item.getItem())));
    }

    protected void setItem(int slot, ItemStack item, Consumer<InventoryClickEvent> action) {
        GUIItem guiItem = new GUIItem(slot, item);
        set(guiItem).onClick(action);
    }

    protected void setItem(int slot, ItemStack item, Collection<StaticNamedState<?>> placeholder) {
        GUIItem guiItem = new GUIItem(slot, item);
        Placeholder.of(placeholder);
        set(guiItem);
    }

    protected void setDecoration() {
        Decoration.setDecoration(this, color1, color2);
    }

    @Override
    public void open(Player player) {
        registerPlaceholders(StateFinder.findStates(this));
        super.open(player);
    }
}
