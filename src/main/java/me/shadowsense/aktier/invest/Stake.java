package me.shadowsense.aktier.invest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@DatabaseTable(tableName = Stake.TABLE_NAME)
public class Stake {
    public static final String TABLE_NAME = "stake";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, columnName = "stock_name")
    private String stockName;
    @DatabaseField(canBeNull = false)
    private int amount;
    @DatabaseField(canBeNull = false)
    private BigDecimal price;

    public Stake() {
    }
}
