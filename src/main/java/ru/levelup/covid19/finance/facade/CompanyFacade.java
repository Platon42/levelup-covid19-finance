package ru.levelup.covid19.finance.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;
import ru.levelup.covid19.finance.service.CompanyDataService;
import ru.levelup.covid19.finance.service.YahooCompanyService;

@Service
public class CompanyFacade {
    @Autowired
    private YahooCompanyService yahooCompanyService;
    @Autowired
    private CompanyDataService companyDataService;

    public CompanyProfileProvider getProfile(CompanySymbol companySymbol) {
        return yahooCompanyService.getCompanyProfile(companySymbol);
    }

    public String getCompanySector(CompanySymbol companySymbol) {
        companyDataService.saveCompanySpringData(yahooCompanyService.getCompanyProfile(companySymbol));
        return companyDataService.getCompanySector(companySymbol);
    }
}
