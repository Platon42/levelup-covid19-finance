package ru.levelup.covid19.finance.service;

import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;

public interface YahooHistoricalService {
    HistoricalDataProvider getHistoricalData(FinancialHistoryDto financialHistoryDto);
}
