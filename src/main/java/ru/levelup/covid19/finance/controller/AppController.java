package ru.levelup.covid19.finance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.ValidationResult;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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
    @PostMapping("/get-mmvb-diff")
    public @ResponseBody Double getMmvbCapDiff(@RequestBody String mmvbCapitalizationDiff) {
        log.info("Получен запрос get-mmvb-diff, входные данные: " + mmvbCapitalizationDiff);
        try {
            ValidationResult validationResult = schemaValidator.validateMmvbCapitalizationDiffDto(mmvbCapitalizationDiff);
            Set<ValidationMessage> messages = validationResult.getValidationMessages();
            if (!messages.isEmpty()) {
                log.error("Ошибка при валидации входных данных запроса get-mmvb-diff");
                return 0.0;
            }
            MmvbCapitalizationDiffDto mmvbCapitalizationDiffDto = objectMapper.readValue(mmvbCapitalizationDiff,
                    MmvbCapitalizationDiffDto.class);
            log.info("Обработан запрос get-mmvb-diff, результат: " + mmvbCapitalizationDiffDto.toString());
            return historyFacade.getDiffCapPercentage(mmvbCapitalizationDiffDto);
        } catch (JsonProcessingException e) {
            log.error("Ошибка при конвертации входных данных запроса get-mmvb-diff: " + e.toString());
        }
        return 0.0;
    }

    /**
     * Метод возвращает медиану по капитализации для индекса ММВБ либо медиану по объему торгов для тикера Yahoo Finance
     * @param financialHistory - DTO с названием индекса ММВБ или тикера Yahoo и датами начала и конца периода
     *                         (в формате "yyyy-MM-dd")
     * @return медиана по капитализации (для индекса ММВБ) или медиана по объему торгов (для тикера Yahoo Finance)
     */
    @PostMapping("/get-median") //объявление POST
    public @ResponseBody BigDecimal getMedianByMarketCap(@RequestBody String financialHistory) {
        log.info("Получен запрос get-median, входные данные: " + financialHistory);
        try {
            ValidationResult validationResult = schemaValidator.validateFinancialHistoryDto(financialHistory);
            Set<ValidationMessage> messages = validationResult.getValidationMessages();
            if (!messages.isEmpty()) {
                log.error("Ошибка при валидации входных данных запроса get-median");
                return new BigDecimal(0);
            }
            FinancialHistoryDto financialHistoryDto = objectMapper.readValue(financialHistory, FinancialHistoryDto.class);
            log.info("Обработан запрос get-median, результат: " + financialHistoryDto.toString());
            return historyFacade.getMarketCapMedian(financialHistoryDto);
        } catch (JsonProcessingException e) {
            log.error("Ошибка при конвертации входных данных запроса get-median: " + e.toString());
        }
        return new BigDecimal(0);
    }

    /**
     * Метод сохраняет в БД статистику по тикеру за заданный период и возвращает DTO со статистикой
     * (Yahoo Finance API)
     * @param financialHistory - DTO с названием тикера и датами начала и конца периода (в формате "yyyy-MM-dd")
     * @return DTO со статистикой за заданный период
     */
    @PostMapping("/get-history")
    public @ResponseBody HistoricalDataProvider getHistory(@RequestBody String financialHistory) {
        log.info("Получен запрос get-history, входные данные: " + financialHistory);
        HistoricalDataProvider historicalDataProvider = new HistoricalDataProvider();
        try {
            ValidationResult validationResult = schemaValidator.validateFinancialHistoryDto(financialHistory);
            Set<ValidationMessage> messages = validationResult.getValidationMessages();
            if (!messages.isEmpty()) {
                log.error("Ошибка при валидации входных данных запроса get-history");
                historicalDataProvider.setError(objectMapper.writeValueAsString(messages));
                return historicalDataProvider;
            }
            FinancialHistoryDto financialHistoryDto = objectMapper.readValue(financialHistory, FinancialHistoryDto.class);
            log.info("Обработан запрос get-history, результат: " + financialHistoryDto.toString());
            return historyFacade.getYahooHistory(financialHistoryDto);
        } catch (JsonProcessingException e) {
            log.error("Ошибка при конвертации входных данных запроса get-history: " + e.toString());
            historicalDataProvider.setError("Ошибка при конвертации входных данных запроса get-history");
        }
        return historicalDataProvider;
    }

    /**
     * Метод возвращает DTO с информацией о профиле компании (Yahoo Finance API)
     * @param ticker - DTO с тикером
     * @return DTO с информацией о профиле компании
     */
    @PostMapping("/get-profile")
    public @ResponseBody CompanyProfileProvider getProfile(@RequestBody String ticker) {
        log.info("Получен запрос get-profile, входные данные: " + ticker);
        CompanyProfileProvider companyProfileProvider = new CompanyProfileProvider();
        try {
            ValidationResult validationResult = schemaValidator.validateTicker(ticker);
            Set<ValidationMessage> messages = validationResult.getValidationMessages();
            if (!messages.isEmpty()) {
                log.error("Ошибка при валидации входных данных запроса get-profile");
                companyProfileProvider.setError(objectMapper.writeValueAsString(messages));
                return companyProfileProvider;
            }
            TickerDto tickerDto = objectMapper.readValue(ticker, TickerDto.class);
            log.info("Обработан запрос get-profile, результат: " + tickerDto.toString());
            return companyFacade.getProfile(tickerDto.getCompanySymbol());
        } catch (JsonProcessingException e) {
            log.error("Ошибка при конвертации входных данных запроса get-profile: " + e.toString());
            companyProfileProvider.setError("Ошибка при конвертации входных данных запроса get-profile");
        }
        return companyProfileProvider;
    }

    /**
     * Метод сохраняет в БД данные о компании и возвращает название сектора, к которому она относится
     * (Yahoo Finance API)
     * @param ticker - DTO с тикером
     * @return строка с названием сектора
     */
    @PostMapping("/get-company-sector")
    public @ResponseBody String getCompanySector(@RequestBody String ticker) {
        log.info("Получен запрос get-company-sector, входные данные: " + ticker);
        try {
            ValidationResult validationResult = schemaValidator.validateTicker(ticker);
            Set<ValidationMessage> messages = validationResult.getValidationMessages();
            if (!messages.isEmpty()) {
                log.error("Ошибка при валидации входных данных запроса get-company-sector");
                return objectMapper.writeValueAsString(messages);
            }
            TickerDto tickerDto = objectMapper.readValue(ticker, TickerDto.class);
            log.info("Обработан запрос get-company-sector, результат: " + tickerDto.toString());
            return companyFacade.getCompanySector(tickerDto.getCompanySymbol());
        } catch (JsonProcessingException e) {
            log.error("Ошибка при конвертации входных данных запроса get-company-sector: " + e.toString());
        }
        return "Ошибка при обработке запроса get-company-sector";
    }

    /**
     * Метод возвращает массив значений капитализации для индекса ММВБ за указанный период
     * @param financialHistory - DTO с названием индекса ММВБ и датами начала и конца периода (в формате "yyyy-MM-dd")
     * @return массив значений капитализации с указанием дат
     */
    @PostMapping("/get-capitalization")
    public @ResponseBody ArrayList<MmvbTradeDay> getCapitalization(@RequestBody String financialHistory) {
        log.info("Получен запрос get-capitalization, входные данные: " + financialHistory);
        try {
            ValidationResult validationResult = schemaValidator.validateFinancialHistoryDto(financialHistory);
            Set<ValidationMessage> messages = validationResult.getValidationMessages();
            if (!messages.isEmpty()) {
                log.error("Ошибка при валидации входных данных запроса get-capitalization");
                return null;
            }
            FinancialHistoryDto financialHistoryDto = objectMapper.readValue(financialHistory, FinancialHistoryDto.class);
            log.info("Обработан запрос get-capitalization, результат: " + financialHistoryDto.toString());
            return historyFacade.getTradeDays(financialHistoryDto);
        } catch (JsonProcessingException e) {
            log.error("Ошибка при конвертации входных данных запроса get-capitalization: " + e.toString());
        }
        return null;
    }

    @GetMapping("/hello")
    public @ResponseBody String getHello() {
        return "Hello world!";
    }
}
