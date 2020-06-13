package ru.levelup.covid19.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;

@Service //объявление синглтона
public class YahooHistoricalServiceImpl implements YahooHistoricalService {

    @Autowired //инъекция бина
            RestTemplate restTemplate;

    //HttpResponse<String> response = Unirest.get("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/
    // get-historical-data?
    // frequency=1d&
    // filter=history&
    // period1=1546448400&
    // period2=1562086800&
    // symbol=AAPL")
    //        .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
    //        .header("x-rapidapi-key", "24127881c1mshdc03b4c52a44067p1c7fd4jsne0d7bd6ff975")
    //        .asString();
    public HistoricalDataProvider getHistoricalData(CompanySymbol symbol,
                                                    String period1, String period2) {

        UriComponentsBuilder uriBuilder =
                UriComponentsBuilder
                        .fromUriString("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-historical-data")
                        .queryParam("frequency", "1d")
                        .queryParam("filter", "history")
                        .queryParam("period1", period1)
                        .queryParam("period2", period2)
                        .queryParam("symbol", symbol);

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
        historicalDataProvider.setId("-1");
        return historicalDataProvider;

    }

}
