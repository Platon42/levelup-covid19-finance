package ru.levelup.covid19.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.levelup.covid19.finance.dto.mmvb.market.MmvbHistory;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbIndex;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MmvbHistoricalServiceImpl implements MmvbHistoricalService {

    @Autowired
    private RestTemplate restTemplate;

    public MmvbHistory getMmvbHistoricalData(FinancialHistoryDto financialHistoryDto) {

        UriComponentsBuilder mmvbHistoryUri =
                UriComponentsBuilder
                        .fromUriString("http://iss.moex.com/iss/history/engines/stock/markets/index/boards/SNDX/securities/"
                        + financialHistoryDto.getCompanySymbol() + ".json")
                        .queryParam("from", financialHistoryDto.getPeriod1())
                        .queryParam("till", financialHistoryDto.getPeriod2());

        MmvbHistory mmvbHistory =
                restTemplate.getForObject(mmvbHistoryUri.toUriString(), MmvbHistory.class, 1);
        if (mmvbHistory == null) return null;
        return mmvbHistory;
    }

    public List<MmvbIndex> getMmvbIndex (MmvbHistory mmvbHistory) {
        List<MmvbIndex> mmvbIndexList = new ArrayList<>();
        mmvbHistory.getHistory()
                .getData()
                .forEach(e-> mmvbIndexList.add(new MmvbIndex(e)));
        return mmvbIndexList;
    }

}
