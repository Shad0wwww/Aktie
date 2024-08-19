package me.shadowsense.aktier.invest;

import eu.okaeri.platform.core.annotation.Component;
import me.shadowsense.aktier.invest.objects.Stock;
import me.shadowsense.aktier.invest.objects.StockUser;

import java.util.UUID;

@Component
public class StockUserManager {

    public void buyStock(Stock stock, int amount, StockUser user) {

    }

    public synchronized void createUser(UUID uuid) {
        new StockUser(uuid, null);
    }
}
