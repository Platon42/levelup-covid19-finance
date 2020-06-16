package ru.levelup.covid19.finance.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;
import ru.levelup.covid19.finance.service.PriceAndHistoryDataService;
import ru.levelup.covid19.finance.service.YahooHistoricalService;

@Service
public class HistoryFacade {

    @Autowired
    private YahooHistoricalService yahooHistoricalService;

    @Autowired
    private PriceAndHistoryDataService priceAndHistoryDataService;

    public String flow(FinancialHistoryDto dto) {
        HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
        priceAndHistoryDataService.saveFinanceDataSpringData(data);
        return "";
    }

    public FinanceHistoryEntity flow2(Integer financeId) {
        return priceAndHistoryDataService.getFinanceHistory(financeId);
    }

}
