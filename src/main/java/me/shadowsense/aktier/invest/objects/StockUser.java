package me.shadowsense.aktier.invest.objects;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
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
    //@DatabaseField(columnName = "stake_id", foreign = true, foreignAutoRefresh = true)
    //private Stake stake;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Stake> stakes;

    public StockUser(UUID uuid) {
        this.uuid = uuid;
    }

    public StockUser() {
    }

    public void addStake(Stake stake) {
        stakes.add(stake);
    }


}
