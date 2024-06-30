package me.shadowsense.aktier.userinterface.serdes;

import me.abdiskiosk.guis.item.PaneColor;
import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;

import java.util.List;

public interface ConfigCompliance {
    String getTitle();
    Integer getSlotSize();
    PaneColor getTopPaneColor();
    PaneColor getBottomPaneColor();
    List<ConfigItem> getItems();

}
