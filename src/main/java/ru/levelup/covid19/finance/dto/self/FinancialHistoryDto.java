package ru.levelup.covid19.finance.dto.self;

import lombok.Data;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;

@Data //геттеры сеттеры Lombok
public class FinancialHistoryDto {
    private String period1;
    private String period2;
    private CompanySymbol companySymbol;
}
