package ru.levelup.covid19.finance.dto.mmvb.statistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//OPEN, HIGH,
//        LOW, VALUE,
//        DURATION, YIELD,
//        DECIMALS, CAPITALIZATION,
//        CURRENCYID, DIVISOR
@Data
@AllArgsConstructor
@ToString
public class MmvbIndex {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String boardId;
    private String secId;
    private Date tradeDate;
    private String shortName;
    private String name;
    private Double close;
    private Double open;
    private Double high;
    private Double low;
    private Double value;
    private Integer duration;
    private Double yield;
    private Integer decimals;
    private Double capitalization;
    private String currencyId;
    private Double divisor;

    @SneakyThrows
    public MmvbIndex(List<String> list) {
        this.boardId = list.get(0);
        this.secId = list.get(1);
        this.tradeDate = dateFormat.parse(list.get(2));
        this.shortName = list.get(3);
        this.name = list.get(4);
        this.close = Double.parseDouble(list.get(5));
        this.open = Double.parseDouble(list.get(6));
        this.high = Double.parseDouble(list.get(7));
        this.low = Double.parseDouble(list.get(8));
        this.value = Double.parseDouble(list.get(9));
        this.duration = Integer.parseInt(list.get(10));
        this.yield = Double.parseDouble(list.get(11));
        this.decimals = Integer.parseInt(list.get(12));
        this.capitalization = Double.parseDouble(list.get(13));
        this.currencyId = list.get(14);
        this.divisor = Double.parseDouble(list.get(15));

    }
}
