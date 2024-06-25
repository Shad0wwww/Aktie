package me.shadowsense.aktier.task;

import eu.okaeri.commons.bukkit.time.MinecraftTimeEquivalent;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.bukkit.annotation.Scheduled;
import me.shadowsense.aktier.config.Config;
import me.shadowsense.aktier.invest.StockManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

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


    }


}
