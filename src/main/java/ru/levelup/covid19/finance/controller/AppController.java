package ru.levelup.covid19.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.yahoo.market.CompanySymbol;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.facade.HistoryFacade;
import ru.levelup.covid19.finance.service.YahooHistoricalService;

@Controller //об'явление коласса контроллера
public class AppController {

    @Autowired // инъекция синглтона
            HistoryFacade historyFacade;

    @PostMapping("/get-history") //объявление POST
    public @ResponseBody
        //ResponseBody класса HistoricalDataProvider
    String getHistory(@RequestBody FinancialHistoryDto financialHistoryDto) {
        historyFacade.flow(financialHistoryDto);
        return historyFacade.flow2(0).toString();
    }
}
