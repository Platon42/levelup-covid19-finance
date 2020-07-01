package ru.levelup.covid19.finance.facade;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.dto.mmvb.market.MmvbHistory;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbIndex;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.Price;
import ru.levelup.covid19.finance.service.MmvbHistoricalService;
import ru.levelup.covid19.finance.service.PriceAndHistoryDataService;
import ru.levelup.covid19.finance.service.YahooHistoricalService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
        return bdMedian.setScale(scale, RoundingMode.HALF_UP);
    }

    public BigDecimal getMarketCapMedian(FinancialHistoryDto dto) {
        Double calcMedian = 0.0;

        if (dto.getProviderName().toLowerCase().equals("yahoo")) {
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
                calcMedian = (mmvbIndices.get(mmvbIndices.size() / 2).getCapitalization() +
                        mmvbIndices.get(mmvbIndices.size() / 2 - 1).getCapitalization()) / 2;
            } else {
                calcMedian = mmvbIndices.get(mmvbIndices.size() / 2).getCapitalization();
            }
        }
        return doubleRound(1, calcMedian);
    }

    public Double getEqualityIndices(FinancialHistoryDto dto) {
        if (dto.getProviderName().toLowerCase().equals("yahoo")) {
            HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
            priceAndHistoryDataService.saveFinanceDataSpringData(data);
            return 0.0;
        }
        if (dto.getProviderName().toLowerCase().equals("mmvb")) {
            MmvbHistory mmvbHistoryNow = mmvbHistoricalService.getMmvbHistoricalData(dto);

            FinancialHistoryDto dtoBefore = (FinancialHistoryDto) dto.clone();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate period1 = LocalDate.parse(dto.getPeriod1());
            LocalDate period2 = LocalDate.parse(dto.getPeriod2());

            dtoBefore.setPeriod2(simpleDateFormat.format(period1.minusYears(1)));
            dtoBefore.setPeriod1(simpleDateFormat.format(period2.minusYears(1)));

            MmvbHistory mmvbHistoryBefore = mmvbHistoricalService.getMmvbHistoricalData(dtoBefore);

            List<MmvbIndex> mmvbIndicesNow =
                    mmvbHistoricalService.getMmvbIndex(mmvbHistoryNow);
            List<MmvbIndex> mmvbIndicesBefore =
                    mmvbHistoricalService.getMmvbIndex(mmvbHistoryBefore);

            Double deltaBefore = mmvbIndicesBefore.get(mmvbIndicesBefore.size() - 1).getClose()
                    - mmvbIndicesBefore.get(0).getClose();
            Double deltaNow = mmvbIndicesNow.get(mmvbIndicesNow.size() - 1).getClose()
                    - mmvbIndicesNow.get(0).getClose();

            return deltaNow - deltaBefore;
        }
        return 0.0;
    }

    public HistoricalDataProvider getYahooHistory(FinancialHistoryDto dto) {
        HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
        priceAndHistoryDataService.saveFinanceDataSpringData(data);
        return data;
    }

    // Рассчитываем разницу закрытия первого и последнего дня заданного периода по индексам
    // Смотрим разницу между получившимся значением и таким же периодом годом ранее
    // Если состояние рынка ухудшилось, получим отрицательное значение, которое покажет увеличение падения индексов

    @SneakyThrows
    public Double getEqualityIndices (FinancialHistoryDto dto) {
        if (dto.getProviderName().toLowerCase().equals("yahoo")) {
            HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(dto);
            priceAndHistoryDataService.saveFinanceDataSpringData(data);
            return 0.0;
        }
        if (dto.getProviderName().toLowerCase().equals("mmvb")) {
            MmvbHistory mmvbHistoryNow = mmvbHistoricalService.getMmvbHistoricalData(dto);

            FinancialHistoryDto dtoBefore = (FinancialHistoryDto) dto.clone();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate period1 =  LocalDate.parse(dto.getPeriod1());
            LocalDate period2 =  LocalDate.parse(dto.getPeriod2());

            dtoBefore.setPeriod2(simpleDateFormat.format(period1.minusYears(1)));
            dtoBefore.setPeriod1(simpleDateFormat.format(period2.minusYears(1)));

            MmvbHistory mmvbHistoryBefore = mmvbHistoricalService.getMmvbHistoricalData(dtoBefore);

            List<MmvbIndex> mmvbIndicesNow =
                    mmvbHistoricalService.getMmvbIndex(mmvbHistoryNow);
            List<MmvbIndex> mmvbIndicesBefore =
                    mmvbHistoricalService.getMmvbIndex(mmvbHistoryBefore);

            Double deltaBefore = mmvbIndicesBefore.get(mmvbIndicesBefore.size() - 1).getClose()
                    - mmvbIndicesBefore.get(0).getClose();
            Double deltaNow = mmvbIndicesNow.get(mmvbIndicesNow.size() - 1).getClose()
                    - mmvbIndicesNow.get(0).getClose();

            return deltaNow - deltaBefore;
        }
        return 0.0;
    }

}
