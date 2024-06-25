package me.shadowsense.aktier.userinterface.serdes;

import me.shadowsense.aktier.userinterface.serdes.item.ConfigItem;

import java.util.List;

public interface ConfigCompliance {
    String getTitle();
    Integer getSlotSize();
    List<ConfigItem> getItems();

}
