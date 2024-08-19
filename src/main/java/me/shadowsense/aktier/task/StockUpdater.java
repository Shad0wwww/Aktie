package me.shadowsense.aktier.task;

import eu.okaeri.injector.annotation.Inject;
import me.shadowsense.aktier.invest.StockManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class StockUpdater extends BukkitRunnable {

    private @Inject Plugin plugin;
    private @Inject StockManager stockManager;

    @Override
    public void run() {

        if (!plugin.isEnabled()) {
            cancel();
            return;
        }

        stockManager.updateStockPrices();
        Bukkit.broadcastMessage("Stock prices updated!");


    }


}
