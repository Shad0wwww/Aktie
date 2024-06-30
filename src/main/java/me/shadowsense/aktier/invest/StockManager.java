package me.shadowsense.aktier.invest;

import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.injector.annotation.PostConstruct;
import eu.okaeri.platform.core.annotation.Component;
import lombok.Getter;
import me.shadowsense.aktier.config.Config;
import me.shadowsense.aktier.config.StockConfig;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class StockManager {

    private @Inject StockConfig stockConfig;
    private @Inject Config config;

    @Getter
    private final Set<Stock> stocks = new HashSet<>();

    @PostConstruct
    public synchronized void load() {
        this.stocks.clear();
        this.stocks.addAll(this.stockConfig.getStocks());
    }


    public synchronized void updateStockPrice(Risk risk, BigDecimal price) throws NullPointerException {
        Stock stock = this.stocks.stream()
                .filter(s -> s.getRisk().equals(risk))
                .findFirst()
                .orElse(null);

        if (stock == null) {
            throw new NullPointerException("Stock not found for risk: " + risk);
        }


        stock.setPrice(price);

    }

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
        this.stocks.forEach(stock -> {
            BigDecimal newPrice = this.calculateNewPrice(stock.getPrice(), stock.getRisk());
            this.updateStockPrice(stock.getRisk(), newPrice);
        });
    }

}
