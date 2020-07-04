package ru.levelup.covid19.finance.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Slf4j
public class SchemaValidator {
    @Autowired
    private ObjectMapper objectMapper;
    private final static JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

    public ValidationResult validateMmvbCapitalizationDiffDto(String jsonInstance) throws JsonProcessingException {
        return getValidationResult(jsonInstance, "./src/main/resources/schema/mmvb_capitalization_diff_dto.json");
    }

    public ValidationResult validateFinancialHistoryDto(String jsonInstance) throws JsonProcessingException {
        return getValidationResult(jsonInstance, "./src/main/resources/schema/financial_history_dto.json");
    }

    public ValidationResult validateTicker(String jsonInstance) throws JsonProcessingException {
        return getValidationResult(jsonInstance, "./src/main/resources/schema/ticker_dto.json");
    }

    private ValidationResult getValidationResult(String jsonInstance, String path) throws JsonProcessingException {
        String rawSchema = null;
        try {
            rawSchema = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            log.info(e.getLocalizedMessage());
        }
        JsonSchema finalSchema = factory.getSchema(rawSchema);
        JsonNode rawNode = objectMapper.readTree(jsonInstance);
        return finalSchema.validateAndCollect(rawNode);
    }
}
