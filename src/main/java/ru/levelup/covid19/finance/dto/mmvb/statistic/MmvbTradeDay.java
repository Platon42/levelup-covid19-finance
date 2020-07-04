package ru.levelup.covid19.finance.dto.mmvb.statistic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class MmvbTradeDay {
    private BigDecimal capitalization;
    private Date tradeDate;
}
