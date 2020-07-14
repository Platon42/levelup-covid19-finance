package ru.levelup.covid19.finance.dto.self;

import lombok.Data;
import ru.levelup.covid19.finance.dto.mmvb.MmvbIndexes;

@Data
public class MmvbCapitalizationDto {
    private String startPeriod;
    private String endPeriod;
    private MmvbIndexes mmvbIndexes;
}
