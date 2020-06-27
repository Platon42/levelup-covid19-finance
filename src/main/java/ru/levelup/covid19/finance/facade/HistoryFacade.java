package ru.levelup.covid19.finance.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.dto.mmvb.market.MmvbHistory;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbIndex;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.jpa.FinanceHistoryEntity;
import ru.levelup.covid19.finance.service.MmvbHistoricalService;
import ru.levelup.covid19.finance.service.PriceAndHistoryDataService;
import ru.levelup.covid19.finance.service.YahooHistoricalService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HistoryFacade {

    @Autowired
    private YahooHistoricalService yahooHistoricalService;

    @Autowired
    private PriceAndHistoryDataService priceAndHistoryDataService;

    @Autowired
    private MmvbHistoricalService mmvbHistoricalService;

    private static BigDecimal doubleRound (int scale, Double num) {
        BigDecimal bdMedian = new BigDecimal(Double.toString(num));
        bdMedian = bdMedian.setScale(scale, RoundingMode.HALF_UP);

        System.out.println("input num:" + num);
        System.out.println("output round:" + bdMedian);
        return bdMedian;
    }

    public BigDecimal getMarketCapMedian(FinancialHistoryDto dto) {
        BigDecimal median = new BigDecimal(0);
        Double calcMedian = 0.0;
        if (dto.getProviderName().toLowerCase().equals("yahoo")) {
            HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
            priceAndHistoryDataService.saveFinanceDataSpringData(data);
            return median;
        }
        if (dto.getProviderName().toLowerCase().equals("mmvb")) {
            MmvbHistory mmvbHistory = mmvbHistoricalService.getMmvbHistoricalData(dto);

            List<MmvbIndex> mmvbIndices =
                    mmvbHistoricalService.getMmvbIndex(mmvbHistory);

            mmvbIndices.sort(new Comparator<MmvbIndex>() {
                @Override
                public int compare(MmvbIndex o1, MmvbIndex o2) {
                    return o1.getCapitalization().compareTo(o2.getCapitalization());
                }
            });
            if (mmvbIndices.size() % 2 == 0) {
                calcMedian = (mmvbIndices.get(mmvbIndices.size()/2).getCapitalization() +
                        mmvbIndices.get(mmvbIndices.size()/2 -1).getCapitalization()) /2;
            } else {
                calcMedian = mmvbIndices.get(mmvbIndices.size()/2).getCapitalization();
            }
        }
        return doubleRound(1, calcMedian);
    }

    public FinanceHistoryEntity flow2(Integer financeId) {
        return priceAndHistoryDataService.getFinanceHistory(financeId);
    }

}
