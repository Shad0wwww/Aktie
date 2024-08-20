package me.shadowsense.aktier.database.stores;

import com.j256.ormlite.dao.Dao;
import me.shadowsense.aktier.database.BaseStore;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.objects.Stake;
import me.shadowsense.aktier.invest.objects.Stock;
import me.shadowsense.aktier.invest.objects.StockUser;
import org.bukkit.OfflinePlayer;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import static com.avaje.ebean.Ebean.update;

public class UserStore extends BaseStore<Integer, StockUser> {
    public UserStore(Dao<StockUser, Integer> dao, StoreManager storeManager, Logger logger) {
        super(dao, storeManager, logger);
    }

    public void create(UUID uuid) {
        StockUser user = new StockUser(uuid);
        persist(user);
    }

    public void create(OfflinePlayer player) {
        create(player.getUniqueId());
    }

    public void addStake(StockUser user, Stake stake) {
        user.addStake(stake);
        update(user);
    }

    public Optional<StockUser> get(UUID uuid) {
        return get("mc_uuid", uuid);
    }

}
