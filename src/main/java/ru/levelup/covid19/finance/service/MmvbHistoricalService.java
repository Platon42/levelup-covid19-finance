package ru.levelup.covid19.finance.service;

import ru.levelup.covid19.finance.dto.mmvb.market.MmvbHistory;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbIndex;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;

import java.util.List;

public interface MmvbHistoricalService {
    MmvbHistory getMmvbHistoricalData(FinancialHistoryDto financialHistoryDto);
    List<MmvbIndex> getMmvbIndex (MmvbHistory mmvbHistory);
}
