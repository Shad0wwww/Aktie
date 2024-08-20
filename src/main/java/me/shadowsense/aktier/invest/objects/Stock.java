package me.shadowsense.aktier.invest.objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.shadowsense.aktier.invest.Risk;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@DatabaseTable(tableName = Stock.TABLE_NAME)
public class Stock {
    public static final String TABLE_NAME = "stock";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, uniqueIndex = true, columnName = "name")
    private String name;
    @DatabaseField(canBeNull = false, columnName = "price")
    private BigDecimal price;
    @DatabaseField(canBeNull = false, columnName = "start_price")
    private BigDecimal startPrice;
    @DatabaseField(canBeNull = false, columnName = "risk")
    private Risk risk;

    public Stock(String name, BigDecimal price, Risk risk, int id, BigDecimal startPrice) {
        this.name = name;
        this.price = price;
        this.risk = risk;
        this.id = id;
        this.startPrice = startPrice;
    }

    public Stock() {
    }

    public Integer procentChange() {
        return (int) (((price.doubleValue() - startPrice.doubleValue()) / startPrice.doubleValue()) * 100);
    }

}
