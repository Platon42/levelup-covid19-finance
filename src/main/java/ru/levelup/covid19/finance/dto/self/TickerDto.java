package ru.levelup.covid19.finance.dto.self;

import lombok.Data;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;

@Data
public class TickerDto {
    private CompanySymbol companySymbol;
}
