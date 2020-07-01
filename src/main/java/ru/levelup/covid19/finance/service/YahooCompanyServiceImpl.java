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
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;

@Service
public class YahooCompanyServiceImpl implements YahooCompanyService {
    @Autowired
    RestTemplate restTemplate;

    public CompanyProfileProvider getCompanyProfile(CompanySymbol companySymbol) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-profile")
                .queryParam("symbol", companySymbol.value);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
        httpHeaders.set("x-rapidapi-key", "21014acd7cmshc48ba722bad03aep1525ecjsn8cbc91beb399");

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<CompanyProfileProvider> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET, httpEntity, CompanyProfileProvider.class, 1);

        if (responseEntity.getBody() != null) {
            return responseEntity.getBody();
        }
        CompanyProfileProvider companyProfileProvider = new CompanyProfileProvider();
        companyProfileProvider.setError("Ошибка при обработке запроса");
        return companyProfileProvider;
    }
}
