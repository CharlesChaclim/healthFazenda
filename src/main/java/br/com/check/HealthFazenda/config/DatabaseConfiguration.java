package br.com.check.HealthFazenda.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("br.com.check.HealthFazenda.repository")
public class DatabaseConfiguration {

}
