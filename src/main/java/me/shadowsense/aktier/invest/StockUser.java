package me.shadowsense.aktier.invest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data @EqualsAndHashCode(callSuper = false)
@DatabaseTable(tableName = StockUser.STOCK_USER)
public class StockUser {

    public static final String STOCK_USER="stock_user";

    @DatabaseField(canBeNull = false, uniqueIndex = true, columnName = "mc_uuid")
    private UUID uuid;


    public StockUser(UUID uuid) {
        this.uuid = uuid;

    }

    public StockUser() {
    }
}
