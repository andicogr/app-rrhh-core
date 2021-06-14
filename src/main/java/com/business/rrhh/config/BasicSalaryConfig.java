package com.business.rrhh.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.config.basic-salary")
public class BasicSalaryConfig {

    private BigDecimal amount;

}
