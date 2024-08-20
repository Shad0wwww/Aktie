package me.shadowsense.aktier.invest;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.objects.Stake;
import me.shadowsense.aktier.invest.objects.Stock;
import me.shadowsense.aktier.invest.objects.StockUser;

import java.util.UUID;

@Component
public class StockUserManager {

    private @Inject StoreManager storeManager;


    public void buyStock(Stock stock, int amount, UUID user) {
        Stake stake = new Stake(stock.getName(), amount, stock.getPrice());
        StockUser stockUser = storeManager.getUserStore().get(user).orElse(new StockUser(user));

        storeManager.getUserStore().addStake(stockUser, stake);
    }

    public synchronized void createUser(UUID uuid) {
        new StockUser(uuid);
    }
}
