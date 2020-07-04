package ru.levelup.covid19.finance.dto.self;

import lombok.Data;
import ru.levelup.covid19.finance.dto.mmvb.MmvbIndexes;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbIndex;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbTradeDay;

import java.util.List;

@Data
public class MmvbCapitalizationDto {
    private String startPeriod;
    private String endPeriod;
    private MmvbIndexes mmvbIndexes;
}
