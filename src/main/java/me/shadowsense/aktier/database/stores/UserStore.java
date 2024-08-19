package me.shadowsense.aktier.database.stores;

import com.j256.ormlite.dao.Dao;
import me.shadowsense.aktier.database.BaseStore;
import me.shadowsense.aktier.database.StoreManager;
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
        StockUser user = new StockUser(uuid, null);
        persist(user);
    }

    public void addStake(OfflinePlayer player, int amount) {
        Optional<StockUser> user = get(player.getUniqueId());
        if (user.isPresent()) {
            user.get().getStake().add(amount);
            update(user.get());
        }
    }

    public Optional<StockUser> get(UUID uuid) {
        return get("mc_uuid", uuid);
    }

}
