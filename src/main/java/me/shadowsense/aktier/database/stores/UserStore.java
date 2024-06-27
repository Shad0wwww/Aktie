package me.shadowsense.aktier.database.stores;

import com.j256.ormlite.dao.Dao;
import me.shadowsense.aktier.database.BaseStore;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.StockUser;
import org.bukkit.OfflinePlayer;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class UserStore extends BaseStore<Integer, StockUser> {
    public UserStore(Dao<StockUser, Integer> dao, StoreManager storeManager, Logger logger) {
        super(dao, storeManager, logger);
    }

    public void update(OfflinePlayer player) {
        get("mc_uuid", player.getUniqueId()).ifPresent(this::persist);
    }

    public Optional<StockUser> get(UUID uuid) {
        return get("mc_uuid", uuid);
    }

}
