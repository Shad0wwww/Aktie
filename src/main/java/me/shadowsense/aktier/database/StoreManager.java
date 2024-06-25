package me.shadowsense.aktier.database;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.LogBackendType;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import eu.okaeri.platform.core.annotation.Component;
import lombok.Getter;
import me.shadowsense.aktier.invest.StockUser;

import javax.annotation.PostConstruct;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
@Component
public class StoreManager {

    @Getter
    private UserStore userStore;

    private ConnectionSource connectionSource;

    public StoreManager(ConnectionSource source) throws SQLException {
        connectionSource = source;
    }

    @PostConstruct
    public void init(Logger logger) throws Exception {
        com.j256.ormlite.logger.Logger.setGlobalLogLevel(Level.ERROR);
        LoggerFactory.setLogBackendType(LogBackendType.JAVA_UTIL);

        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + "plugins/Aktier/stock.db");
            Set<String> tableNames = getCreatedTables();

            if (!tableNames.contains(StockUser.STOCK_USER)) {
                TableUtils.clearTable(connectionSource, StockUser.class);
            }


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
    }

    private Set<String> getCreatedTables() throws SQLException {
        DatabaseMetaData metaData = connectionSource.getReadWriteConnection("").getUnderlyingConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, "%", null);

        // Create a Set to hold table names
        Set<String> tableNames = new HashSet<>();

        while (tables.next()) {
            tableNames.add(tables.getString(3).toLowerCase());
        }

        return tableNames;
    }

    private static boolean isSqlite(String jdbc) {
        return jdbc.startsWith("jdbc:sqlite:");
    }

    public void disconnect() throws Exception {
        this.userStore = null;
        connectionSource.close();
    }

}
