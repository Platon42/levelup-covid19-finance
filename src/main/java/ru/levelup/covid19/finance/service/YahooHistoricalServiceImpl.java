package ru.levelup.covid19.finance.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Service //объявление синглтона
public class YahooHistoricalServiceImpl implements YahooHistoricalService {

    @Autowired //инъекция бина
    private RestTemplate restTemplate;

    public String convertDateToUnix(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return Long.toString(dateFormat.parse(date).getTime() / 1000);
    }

    @SneakyThrows
    public HistoricalDataProvider getHistoricalData(FinancialHistoryDto financialHistoryDto) {
        String dateFrom = convertDateToUnix(financialHistoryDto.getPeriod1());
        String dateTo = convertDateToUnix(financialHistoryDto.getPeriod2());

        UriComponentsBuilder uriBuilder =
                UriComponentsBuilder
                        .fromUriString("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-historical-data")
                        .queryParam("frequency", "1d")
                        .queryParam("filter", "history")
                        .queryParam("period1", dateFrom)
                        .queryParam("period2", dateTo)
                        .queryParam("symbol", financialHistoryDto.getCompanySymbol());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
        httpHeaders.set("x-rapidapi-key", "24127881c1mshdc03b4c52a44067p1c7fd4jsne0d7bd6ff975");

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<HistoricalDataProvider> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET, httpEntity, HistoricalDataProvider.class, 1);

        if (responseEntity.getBody() != null) {
            return responseEntity.getBody();
        }
        HistoricalDataProvider historicalDataProvider = new HistoricalDataProvider();
        historicalDataProvider.setError("Ошибка при обработке запроса");
        return historicalDataProvider;
    }
}
