package me.shadowsense.aktier.database.stores;

import com.j256.ormlite.dao.Dao;
import me.shadowsense.aktier.database.BaseStore;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.objects.Stock;

import java.util.List;
import java.util.logging.Logger;

public class StockStore extends BaseStore<Integer, Stock> {

    public StockStore() {
        super(null, null, null);
    }

    public StockStore(Dao<Stock, Integer> dao, StoreManager stores, Logger logger) {
        super(dao, stores, logger);
    }

    public void update(Stock stock) {
        persist(stock);
    }

    public void create(Stock stock) {
        if (exists(stock.getName())) {
            return;
        }

        persist(stock);
    }

    public Boolean exists(String stockName) {
        return get("name", stockName.toLowerCase()).isPresent();
    }

    @Override
    public List<Stock> getAll() {
        return super.getAll();
    }
}
