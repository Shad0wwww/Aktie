package me.shadowsense.aktier.invest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@Data @EqualsAndHashCode(callSuper = false)
@DatabaseTable(tableName = StockUser.STOCK_USER)
public class StockUser {

    public static final String STOCK_USER="stock_user";

    @DatabaseField(canBeNull = false, uniqueIndex = true, columnName = "mc_uuid")
    private UUID uuid;

    @DatabaseField(canBeNull = false, columnName = "stocks")
    private Map<Stock, BigDecimal> stocks;

    public StockUser(UUID uuid, Map<Stock, BigDecimal> stocks) {
        this.uuid = uuid;
        this.stocks = stocks;
    }

    public StockUser() {
    }
}
