package ru.levelup.covid19.finance.service;

import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;

public interface YahooCompanyService {
    CompanyProfileProvider getCompanyProfile(CompanySymbol companySymbol);
}
