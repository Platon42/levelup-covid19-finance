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
        FinanceHistoryEntity financeHistoryEntity = new FinanceHistoryEntity();
        financeHistoryEntity.setFirstTradeDate(historicalDataProvider.getFirstTradeDate());
        financeHistoryEntity.setPending(historicalDataProvider.getIsPending());
        historyRepoSpringData.save(financeHistoryEntity);


        List<Price> prices = historicalDataProvider.getPrices();
        prices.forEach(price -> {
            PriceEntity priceEntity = new PriceEntity();
            priceEntity.setDate(price.getDate());
            priceEntity.setHigh(price.getHigh());
            priceEntity.setLow(price.getLow());
            priceEntity.setAdjclose(price.getAdjclose());
            priceEntity.setOpen(price.getOpen());
            priceEntity.setFinanceHistoryByFinanceHistoryId(financeHistoryEntity);
            priceRepoSpringData.save(priceEntity);
        });

    }

    public FinanceHistoryEntity getFinanceHistory(Integer financeId) {
        return historyRepoMyBatis.getFinanceHistoryMyBatis(financeId);
    }


}
