package ru.levelup.covid19.finance.dto.self;

import lombok.Data;
import ru.levelup.covid19.finance.dto.mmvb.MmvbIndexes;

@Data
public class MmvbCapitalizationDiffDto {
    private String startFromPeriod;
    private String endFromPeriod;
    private String startToPeriod;
    private String endToPeriod;
    private MmvbIndexes mmvbIndex;
}
