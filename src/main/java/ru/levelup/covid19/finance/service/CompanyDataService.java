package ru.levelup.covid19.finance.service;

import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;
import ru.levelup.covid19.finance.jpa.CompanyEntity;

public interface CompanyDataService {
    void saveCompanySpringData(CompanyProfileProvider companyProfileProvider);
    String getCompanySector(CompanySymbol companySymbol);
}
