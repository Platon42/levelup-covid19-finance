package ru.levelup.covid19.finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration // объявление класса конфигурации Spring
public class RestTemplateConfig {

@Bean // бин возващающий REST TEMPLATE
public RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
    defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
    restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
    return restTemplate;
}
}