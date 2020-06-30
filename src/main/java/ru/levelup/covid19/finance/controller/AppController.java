package ru.levelup.covid19.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.self.TickerDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;
import ru.levelup.covid19.finance.facade.CompanyFacade;
import ru.levelup.covid19.finance.facade.HistoryFacade;

import java.math.BigDecimal;

@Controller //об'явление класса контроллера
public class AppController {

    @Autowired // инъекция синглтона
    private HistoryFacade historyFacade;

    @Autowired
    private CompanyFacade companyFacade;

    /**
     * Метод возвращает медиану по капитализации для индекса ММВБ либо медиану по объему торгов для тикера Yahoo Finance
     * @param financialHistoryDto - DTO с названием индекса ММВБ или тикера Yahoo и датами начала и конца периода
     *                            (в формате "yyyy-MM-dd")
     * @return медиана по капитализации (для индекса ММВБ) или медиана по объему торгов (для тикера Yahoo Finance)
     */
    @PostMapping("/get-median") //объявление POST
    public @ResponseBody
    BigDecimal getMedianByMarketCap(@RequestBody FinancialHistoryDto financialHistoryDto) {
        return historyFacade.getMarketCapMedian(financialHistoryDto);
    }

    /**
     * Метод сохраняет в БД статистику по тикеру за заданный период и возвращает DTO со статистикой
     * (Yahoo Finance API)
     * @param financialHistoryDto - DTO с названием тикера и датами начала и конца периода (в формате "yyyy-MM-dd")
     * @return DTO со статистикой за заданный период
     */
    @PostMapping("/get-history") //объявление POST
    public @ResponseBody //ResponseBody класса HistoricalDataProvider
    HistoricalDataProvider getHistory(@RequestBody FinancialHistoryDto financialHistoryDto) {
        return historyFacade.getYahooHistory(financialHistoryDto);
    }

    /**
     * Метод возвращает DTO с информацией о профиле компании (Yahoo Finance API)
     * @param tickerDto - DTO с тикером
     * @return DTO с информацией о профиле компании
     */
    @PostMapping("/get-profile")
    public @ResponseBody CompanyProfileProvider getProfile(@RequestBody TickerDto tickerDto) {
        return companyFacade.getProfile(tickerDto.getCompanySymbol());
    }

    /**
     * Метод сохраняет в БД данные о компании и возвращает название сектора, к которому она относится
     * (Yahoo Finance API)
     * @param tickerDto - DTO с тикером
     * @return строка с названием сектора
     */
    @PostMapping("/get-company-sector")
    public @ResponseBody String getCompanySector(@RequestBody TickerDto tickerDto) {
        return companyFacade.getCompanySector(tickerDto.getCompanySymbol());
    }
}
