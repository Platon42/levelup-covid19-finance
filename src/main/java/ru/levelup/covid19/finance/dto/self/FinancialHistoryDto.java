package ru.levelup.covid19.finance.dto.self;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;

@Data //геттеры сеттеры Lombok
@AllArgsConstructor
public class FinancialHistoryDto {
    private String providerName;
    private String period1;
    private String period2;
    private String companySymbol;
    public FinancialHistoryDto() {
        // do nothing
    }
}
