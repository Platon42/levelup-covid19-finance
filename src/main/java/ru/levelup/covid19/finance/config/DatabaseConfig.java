package ru.levelup.covid19.finance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${database.password}")
    private String databasePass;

    @Bean
    @Primary
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://95.163.214.27:5432/covid");
        dataSourceBuilder.username("covid");
        dataSourceBuilder.password(databasePass);
        return dataSourceBuilder.build();
    }
}
