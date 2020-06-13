package ru.levelup.covid19.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.levelup.covid19.finance.dto.self.FinancialHistory;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.service.YahooHistoricalService;

@Controller //об'явление коласса контроллера
public class AppController {

    @Autowired // инъекция синглтона
    private YahooHistoricalService yahooHistoricalService;

    @PostMapping("/get-history") //объявление POST
    public @ResponseBody
        //ResponseBody класса HistoricalDataProvider
    HistoricalDataProvider getHistory(@RequestBody FinancialHistory financialHistory) {
        String period1 = financialHistory.getPeriod1();
        String period2 = financialHistory.getPeriod2();

        CompanySymbol companySymbol = financialHistory.getCompanySymbol();
        HistoricalDataProvider data = yahooHistoricalService.getHistoricalData(companySymbol, period1, period2);
        return data;
    }
}
