package ru.levelup.covid19.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.Price;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;
import ru.levelup.covid19.finance.jpa.PriceEntity;
import ru.levelup.covid19.finance.repository.hibernate.HistoryRepoSpringData;
import ru.levelup.covid19.finance.repository.hibernate.PriceRepoSpringData;
import ru.levelup.covid19.finance.repository.mybatis.HistoryRepoMyBatis;

import java.util.List;

@Service
public class PriceAndHistoryDataServiceImpl implements PriceAndHistoryDataService {

    @Autowired
    private HistoryRepoSpringData historyRepoSpringData;
    @Autowired
    private PriceRepoSpringData priceRepoSpringData;
    @Autowired
    private HistoryRepoMyBatis historyRepoMyBatis;

    public void saveFinanceDataSpringData(HistoricalDataProvider historicalDataProvider) {
        if (historicalDataProvider == null || !historicalDataProvider.getError().isEmpty())
            return;

        FinanceHistoryEntity financeHistoryEntity = new FinanceHistoryEntity();
        financeHistoryEntity.setPending(historicalDataProvider.getIsPending());
        financeHistoryEntity.setFirstTradeDate(historicalDataProvider.getFirstTradeDate());
        financeHistoryEntity.setId(historicalDataProvider.getId());
        financeHistoryEntity.setTimeZone(historicalDataProvider.getTimeZone().getGmtOffset().toString());

        List<Price> prices = historicalDataProvider.getPrices();
        double sumHigh = 0;
        if (prices != null) {
            sumHigh = prices.stream().mapToDouble(Price::getHigh).sum();
        }
        financeHistoryEntity.setSumHigh(sumHigh);
        historyRepoSpringData.save(financeHistoryEntity);

        if (prices != null) {
            prices.forEach(price -> {
                PriceEntity priceEntity = new PriceEntity();
                priceEntity.setDate(price.getDate());
                priceEntity.setOpen(price.getOpen());
                priceEntity.setHigh(price.getHigh());
                priceEntity.setLow(price.getLow());
                priceEntity.setClose(price.getClose());
                priceEntity.setAdjclose(price.getAdjclose());
                priceEntity.setVolume(price.getVolume());
                priceEntity.setFinanceHistoryByFinanceHistoryId(financeHistoryEntity);
                priceRepoSpringData.save(priceEntity);
            });
        }
    }

    public FinanceHistoryEntity getFinanceHistory(Integer financeId) {
        return historyRepoMyBatis.getFinanceHistoryMyBatis(financeId);
    }
}
