package ru.levelup.covid19.finance.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.dto.ApiType;
import ru.levelup.covid19.finance.dto.mmvb.MmvbIndexes;
import ru.levelup.covid19.finance.dto.mmvb.market.MmvbHistory;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbIndex;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.self.MmvbCapitalizationDiffDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.Price;
import ru.levelup.covid19.finance.service.MmvbHistoricalService;
import ru.levelup.covid19.finance.service.PriceAndHistoryDataService;
import ru.levelup.covid19.finance.service.YahooHistoricalService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class HistoryFacade {

    private static int scaleTwo = 2;
    private static int scaleOne = 1;
    private static final int  ONU_HUNDRED_PERCENT = 100;

    @Autowired
    private YahooHistoricalService yahooHistoricalService;

    @Autowired
    private PriceAndHistoryDataService priceAndHistoryDataService;

    @Autowired
    private MmvbHistoricalService mmvbHistoricalService;

    private static BigDecimal doubleRound (int scale, Double num) {
        BigDecimal bdMedian = new BigDecimal(Double.toString(num));
        return bdMedian.setScale(scale, RoundingMode.HALF_UP);
    }

    private double getMedianMmvbIndexes(MmvbHistory mmvbHistory) {
        List<MmvbIndex> mmvbIndexes = mmvbHistoricalService.getMmvbIndex(mmvbHistory);
        mmvbIndexes.sort(new Comparator<MmvbIndex>() {
            @Override
            public int compare(MmvbIndex o1, MmvbIndex o2) {
                return o1.getCapitalization().compareTo(o2.getCapitalization());
            }
        });
        double median = 0.0;
        if (mmvbIndexes.size() % 2 == 0) {
            median = (mmvbIndexes.get(mmvbIndexes.size()/2).getCapitalization() +
                    mmvbIndexes.get(mmvbIndexes.size()/2 - 1).getCapitalization()) /2;
        } else {
            median = mmvbIndexes.get(mmvbIndexes.size()/2).getCapitalization();
        }
        return median;
    }

    private double calcDiffPercentage(final BigDecimal valFrom, final BigDecimal valTo) {
        BigDecimal currValue = valFrom.subtract(valTo);
        currValue = currValue.divide(valTo, scaleTwo, RoundingMode.HALF_UP);
        return currValue.doubleValue() * ONU_HUNDRED_PERCENT;
    }

    public BigDecimal getMarketCapMedian(FinancialHistoryDto dto) {
        Double calcMedian = 0.0;

        if (dto.getProviderName().toLowerCase().equals(ApiType.YAHOO.value)) {
            HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
            List<Price> prices = data.getPrices();
            prices.sort(new Comparator<Price>() {
                @Override
                public int compare(Price p1, Price p2) {
                    return p1.getVolume().compareTo(p2.getVolume());
                }
            });
            int size = prices.size();
            if (size % 2 == 0) {
                calcMedian = (double) (prices.get(size/2).getVolume() + prices.get(size/2 - 1).getVolume()) / 2;
            } else {
                calcMedian = (double) prices.get(size/2).getVolume();
            }
        }

        if (dto.getProviderName().toLowerCase().equals(ApiType.MMVB.value)) {
            MmvbHistory mmvbHistory = mmvbHistoricalService.getMmvbHistoricalData(dto);
            calcMedian = getMedianMmvbIndexes(mmvbHistory);
        }
        return doubleRound(scaleOne, calcMedian);
    }

    public HistoricalDataProvider getYahooHistory(FinancialHistoryDto dto) {
        HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
        priceAndHistoryDataService.saveFinanceDataSpringData(data);
        return data;
    }

    public double getDiffCapPercentage(MmvbCapitalizationDiffDto dto) {
        FinancialHistoryDto dtoFrom = new FinancialHistoryDto(ApiType.MMVB.value, dto.getStartFromPeriod(), dto.getEndFromPeriod(), dto.getMmvbIndex().value);
        MmvbHistory mmvbHistoryFrom = mmvbHistoricalService.getMmvbHistoricalData(dtoFrom);
        BigDecimal medianFrom = doubleRound(1, getMedianMmvbIndexes(mmvbHistoryFrom));

        FinancialHistoryDto dtoTo = new FinancialHistoryDto(ApiType.MMVB.value, dto.getStartToPeriod(), dto.getEndToPeriod(), dto.getMmvbIndex().value);
        MmvbHistory mmvbHistoryTo = mmvbHistoricalService.getMmvbHistoricalData(dtoTo);
        BigDecimal medianTo = doubleRound(1, getMedianMmvbIndexes(mmvbHistoryTo));

        double result = 0.0;
        if (medianTo.compareTo(medianFrom) > 0) {
            result = calcDiffPercentage(medianTo, medianFrom);
        } else if (medianTo.compareTo(medianFrom) < 0) {
            result = -1 * calcDiffPercentage(medianFrom, medianTo);
        }
        return result;
    }
}
