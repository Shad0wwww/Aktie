package me.shadowsense.aktier.userinterface;

import eu.okaeri.injector.annotation.PostConstruct;
import eu.okaeri.placeholders.Placeholders;
import eu.okaeri.platform.core.annotation.Component;
import me.abdiskiosk.guis.GUIManager;
import org.bukkit.plugin.Plugin;

@Component
public class GUIHandler {
    @PostConstruct
    public void registerListeners(Plugin plugin) {
        GUIManager.registerListeners(plugin);
    }

    @PostConstruct
    public void setPlaceholders(Placeholders placeholders) {
        GUIManager.getInstance().setPlaceholderApplier(new OkaeriGUIPlaceholderApplier(placeholders));
    }
}
