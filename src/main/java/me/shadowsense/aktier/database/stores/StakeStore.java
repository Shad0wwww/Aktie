package me.shadowsense.aktier.database.stores;

import com.j256.ormlite.dao.Dao;
import me.shadowsense.aktier.database.BaseStore;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.objects.Stake;

import java.util.logging.Logger;

public class StakeStore extends BaseStore<Integer, Stake> {

    public StakeStore(Dao<Stake, Integer> dao, StoreManager stores, Logger logger) {
        super(dao, stores, logger);
    }

    public void update(Stake stake) {
        persist(stake);
    }


}
