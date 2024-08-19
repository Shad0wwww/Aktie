package me.shadowsense.aktier.invest.objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@DatabaseTable(tableName = StockUser.TABLE_NAME)
public class StockUser {
    public static final String TABLE_NAME = "stock_user";
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, uniqueIndex = true, columnName = "mc_uuid")
    private UUID uuid;
    @DatabaseField(columnName = "stake_id", foreign = true, foreignAutoRefresh = true)
    private Stake stake;

    public StockUser(UUID uuid, Stake stake) {
        this.uuid = uuid;
        this.stake = stake;
    }

    public StockUser() {
    }


}
