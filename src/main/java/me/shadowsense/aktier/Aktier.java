package me.shadowsense.aktier;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import eu.okaeri.i18n.configs.LocaleConfig;
import eu.okaeri.injector.Injector;
import eu.okaeri.placeholders.Placeholders;
import eu.okaeri.platform.bukkit.OkaeriBukkitPlugin;
import eu.okaeri.platform.core.annotation.Bean;
import eu.okaeri.platform.core.annotation.Scan;
import eu.okaeri.platform.core.config.EmptyConfig;
import eu.okaeri.platform.core.plan.ExecutionPhase;
import eu.okaeri.platform.core.plan.Planned;
import me.shadowsense.aktier.config.Config;
import me.shadowsense.aktier.database.StoreManager;
import me.shadowsense.aktier.task.StockUpdater;
import me.shadowsense.aktier.utils.PlaceholderResolvers;

import java.io.File;

@Scan(exclusions = "me.shadowsense.aktier.libs", deep = true)
public final class Aktier extends OkaeriBukkitPlugin {

    @Bean
    public EmptyConfig loadLocaleConfigForCommands(LocaleConfig localeConfig) {
        return ConfigManager.create(EmptyConfig.class, (it) -> {
            it.withConfigurer(new YamlSnakeYamlConfigurer(), new SerdesBukkit());
            it.withBindFile(new File(new File(this.getDataFolder(), "i18n"), "dk.yml"));
            it.withRemoveOrphans(false);
            it.saveDefaults();
            it.load(false);
        });
    }

    @Planned(ExecutionPhase.SHUTDOWN)
    public void shutdownStores(StoreManager stores) throws Exception {
        stores.disconnect();
    }

    @Planned(ExecutionPhase.POST_SETUP)
    public void setupTasks(Injector injector, Config config) {
        injector.createInstance(StockUpdater.class)
                .runTaskTimer(this, 20L, 20L * 60 * config.getUpdateInterval());
    }

    private PlaceholderResolvers resolvers;
    @Planned(ExecutionPhase.PRE_SETUP)
    public void setupPlaceholders(Placeholders placeholders) {
        this.resolvers = new PlaceholderResolvers();
        resolvers.registerPlaceholderResolvers(placeholders);
    }





}
