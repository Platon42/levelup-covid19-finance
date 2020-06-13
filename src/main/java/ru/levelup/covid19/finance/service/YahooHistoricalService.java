package ru.levelup.covid19.finance.service;

import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;

public interface YahooHistoricalService {
    HistoricalDataProvider getHistoricalData(CompanySymbol symbol,
                                             String period1, String period2);
}
