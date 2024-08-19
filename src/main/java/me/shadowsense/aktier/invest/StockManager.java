package me.shadowsense.aktier.invest;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.core.annotation.Component;
import me.shadowsense.aktier.config.Config;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.invest.objects.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Component
public class StockManager {

    private @Inject Config config;
    private @Inject StoreManager storeManager;

    private BigDecimal calculateNewPrice(BigDecimal price, Risk risk) {
        Random random = new Random();
        int percentageChange = this.getPercentageChange(risk);

        BigDecimal change = price.multiply(new BigDecimal(percentageChange))
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);

        if (random.nextBoolean()) {
            price = price.add(change);
        } else {
            price = price.subtract(change);
        }

        return price;
    }

    private Integer getPercentageChange(Risk risk) {
        Random random = new Random();
        switch (risk) {
            case LOW:
                return random.nextInt(config.getLowStockProcent());
            case MEDIUM:
                return random.nextInt(config.getMediumStockProcent());
            case HIGH:
                return random.nextInt(config.getHighStockProcent());
        }
        return 0;
    }

    public synchronized void updateStockPrices() {
        for (Stock stock : storeManager.getStockStore().getAll()) {
            stock.setPrice(this.calculateNewPrice(stock.getPrice(), stock.getRisk()));
            storeManager.getStockStore().update(stock);
        }
    }

}
