package me.shadowsense.aktier.userinterface;

import lombok.Getter;
import me.abdiskiosk.guis.event.GUIClickEventHandler;
import me.abdiskiosk.guis.gui.AutoUpdatingGUI;
import me.abdiskiosk.guis.item.GUIItem;
import me.abdiskiosk.guis.item.PaneColor;
import me.abdiskiosk.guis.reflection.StateFinder;
import me.shadowsense.aktier.userinterface.serdes.ConfigCompliance;
import me.shadowsense.aktier.userinterface.util.Decoration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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

    protected void setItem(int slot, ItemStack item, InventoryClickEvent action) {
        set(new GUIItem(slot, item)).handleClick(action);
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
