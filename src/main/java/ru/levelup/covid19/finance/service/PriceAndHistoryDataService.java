package ru.levelup.covid19.finance.service;

import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;

public interface PriceAndHistoryDataService {
    void saveFinanceDataSpringData(HistoricalDataProvider historicalDataProvider);

    FinanceHistoryEntity getFinanceHistory(Integer financeId);
}
