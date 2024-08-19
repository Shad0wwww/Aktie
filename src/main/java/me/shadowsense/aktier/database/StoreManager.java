package me.shadowsense.aktier.database;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.LogBackendType;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.injector.annotation.PostConstruct;
import eu.okaeri.platform.core.annotation.Bean;
import eu.okaeri.platform.core.annotation.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shadowsense.aktier.Aktier;
import me.shadowsense.aktier.database.stores.StakeStore;
import me.shadowsense.aktier.database.stores.StockStore;
import me.shadowsense.aktier.database.stores.UserStore;
import me.shadowsense.aktier.invest.objects.Stake;
import me.shadowsense.aktier.invest.objects.Stock;
import me.shadowsense.aktier.invest.objects.StockUser;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Logger;

@Service
@NoArgsConstructor
public class StoreManager {

    @Getter
    private @Inject Aktier plugin;

    private UserStore userStore;
    private StakeStore stakeStore;
    private StockStore stockStore;

    @Getter
    private ConnectionSource connectionSource;


    @PostConstruct
    public void init(Logger logger) throws SQLException  {
        com.j256.ormlite.logger.Logger.setGlobalLogLevel(Level.ERROR);
        LoggerFactory.setLogBackendType(LogBackendType.JAVA_UTIL);

        try {
            connectionSource = new JdbcConnectionSource(getConnectionUrl());

            TableUtils.createTableIfNotExists(connectionSource, StockUser.class);
            TableUtils.createTableIfNotExists(connectionSource, Stake.class);
            TableUtils.createTableIfNotExists(connectionSource, Stock.class);
        } catch(Exception ex) {
            logger.severe("========================================");
            logger.severe("=                                      =");
            logger.severe("=   DATABASE CONNECTION FAILURE        =");
            logger.severe("=                                      =");
            logger.severe("=   Failed to establish connection     =");
            logger.severe("=   with the database.                 =");
            logger.severe("=                                      =");
            logger.severe("=   Please check your configuration.   =");
            logger.severe("=                                      =");
            logger.severe("========================================");
            throw ex;
        }

        this.userStore = new UserStore(DaoManager.createDao(connectionSource, StockUser.class), this, logger);
        this.stakeStore = new StakeStore(DaoManager.createDao(connectionSource, Stake.class), this, logger);
        this.stockStore = new StockStore(DaoManager.createDao(connectionSource, Stock.class), this, logger);
    }

    public String getConnectionUrl() {
        String databaseType = "sqlite";
        String databasePath = plugin.getDataFolder() + File.separator + plugin.getDescription().getName();
        return "jdbc:" + databaseType + ":" + databasePath + ".db";
    }

    public void disconnect() throws Exception {
        this.userStore = null;
        connectionSource.close();
    }

    @Bean
    public UserStore getUserStore() {
        return userStore;
    }
    @Bean
    public StakeStore getStakeStore() {
        return stakeStore;
    }
    @Bean
    public StockStore getStockStore() {
        return stockStore;
    }
}
