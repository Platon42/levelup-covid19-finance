package ru.levelup.covid19.finance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.ValidationResult;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.levelup.covid19.finance.dto.mmvb.statistic.MmvbTradeDay;
import ru.levelup.covid19.finance.dto.self.FinancialHistoryDto;
import ru.levelup.covid19.finance.dto.self.MmvbCapitalizationDiffDto;
import ru.levelup.covid19.finance.dto.self.TickerDto;
import ru.levelup.covid19.finance.dto.yahoo.stock.historical.HistoricalDataProvider;
import ru.levelup.covid19.finance.dto.yahoo.stock.profile.CompanyProfileProvider;
import ru.levelup.covid19.finance.facade.CompanyFacade;
import ru.levelup.covid19.finance.facade.HistoryFacade;
import ru.levelup.covid19.finance.utils.SchemaValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

@Controller //об'явление класса контроллера
public class AppController {

    @Autowired // инъекция синглтона
    private HistoryFacade historyFacade;
    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private SchemaValidator schemaValidator;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Получить изменение значения капитализации индекса ММВБ за два периода
     * @return значение (%)
     */
    @SneakyThrows
    @PostMapping("/get-mmvb-diff")
    public @ResponseBody Double getMmvbCapDiff(@RequestBody String mmvbCapitalizationDiff) {
        ValidationResult validationResult = schemaValidator.validateMmvbCapitalizationDiffDto(mmvbCapitalizationDiff);
        Set<ValidationMessage> messages = validationResult.getValidationMessages();
        if (!messages.isEmpty()) {
            return 0.0;
        }

        MmvbCapitalizationDiffDto mmvbCapitalizationDiffDto = objectMapper.readValue(mmvbCapitalizationDiff,
                MmvbCapitalizationDiffDto.class);
        return historyFacade.getDiffCapPercentage(mmvbCapitalizationDiffDto);
    }

    /**
     * Метод возвращает медиану по капитализации для индекса ММВБ либо медиану по объему торгов для тикера Yahoo Finance
     * @param financialHistory - DTO с названием индекса ММВБ или тикера Yahoo и датами начала и конца периода
     *                         (в формате "yyyy-MM-dd")
     * @return медиана по капитализации (для индекса ММВБ) или медиана по объему торгов (для тикера Yahoo Finance)
     */
    @SneakyThrows
    @PostMapping("/get-median") //объявление POST
    public @ResponseBody BigDecimal getMedianByMarketCap(@RequestBody String financialHistory) {
        ValidationResult validationResult = schemaValidator.validateFinancialHistoryDto(financialHistory);
        Set<ValidationMessage> messages = validationResult.getValidationMessages();
        if (!messages.isEmpty()) {
            return new BigDecimal(0);
        }

        FinancialHistoryDto financialHistoryDto = objectMapper.readValue(financialHistory, FinancialHistoryDto.class);
        return historyFacade.getMarketCapMedian(financialHistoryDto);
    }

    /**
     * Метод сохраняет в БД статистику по тикеру за заданный период и возвращает DTO со статистикой
     * (Yahoo Finance API)
     * @param financialHistory - DTO с названием тикера и датами начала и конца периода (в формате "yyyy-MM-dd")
     * @return DTO со статистикой за заданный период
     */
    @SneakyThrows
    @PostMapping("/get-history")
    public @ResponseBody HistoricalDataProvider getHistory(@RequestBody String financialHistory) {
        ValidationResult validationResult = schemaValidator.validateFinancialHistoryDto(financialHistory);
        Set<ValidationMessage> messages = validationResult.getValidationMessages();
        if (!messages.isEmpty()) {
            HistoricalDataProvider historicalDataProvider = new HistoricalDataProvider();
            historicalDataProvider.setError(objectMapper.writeValueAsString(messages));
            return historicalDataProvider;
        }

        FinancialHistoryDto financialHistoryDto = objectMapper.readValue(financialHistory, FinancialHistoryDto.class);
        return historyFacade.getYahooHistory(financialHistoryDto);
    }

    /**
     * Метод возвращает DTO с информацией о профиле компании (Yahoo Finance API)
     * @param ticker - DTO с тикером
     * @return DTO с информацией о профиле компании
     */
    @SneakyThrows
    @PostMapping("/get-profile")
    public @ResponseBody CompanyProfileProvider getProfile(@RequestBody String ticker) {
        ValidationResult validationResult = schemaValidator.validateTicker(ticker);
        Set<ValidationMessage> messages = validationResult.getValidationMessages();
        if (!messages.isEmpty()) {
            CompanyProfileProvider companyProfileProvider = new CompanyProfileProvider();
            companyProfileProvider.setError(objectMapper.writeValueAsString(messages));
            return companyProfileProvider;
        }

        TickerDto tickerDto = objectMapper.readValue(ticker, TickerDto.class);
        return companyFacade.getProfile(tickerDto.getCompanySymbol());
    }

    /**
     * Метод сохраняет в БД данные о компании и возвращает название сектора, к которому она относится
     * (Yahoo Finance API)
     * @param ticker - DTO с тикером
     * @return строка с названием сектора
     */
    @SneakyThrows
    @PostMapping("/get-company-sector")
    public @ResponseBody
    String getCompanySector(@RequestBody String ticker) {
        ValidationResult validationResult = schemaValidator.validateTicker(ticker);
        Set<ValidationMessage> messages = validationResult.getValidationMessages();
        if (!messages.isEmpty()) {
            return objectMapper.writeValueAsString(messages);
        }

        TickerDto tickerDto = objectMapper.readValue(ticker, TickerDto.class);
        return companyFacade.getCompanySector(tickerDto.getCompanySymbol());
    }

    @PostMapping("/get-capitalization")
    public @ResponseBody
    ArrayList<MmvbTradeDay> getCapitalization(@RequestBody FinancialHistoryDto financialHistoryDto) {
        return historyFacade.getTradeDays(financialHistoryDto);
    }

    @GetMapping("/hello")
    public @ResponseBody
    String getHello() {
        return "Hello world!";
    }
}
