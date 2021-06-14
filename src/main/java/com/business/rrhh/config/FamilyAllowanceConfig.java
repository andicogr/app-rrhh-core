package com.business.rrhh.config;

import com.business.rrhh.util.FamilyAllowanceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.config.family-allowance")
public class FamilyAllowanceConfig {

    private BigDecimal percentage;
    private FamilyAllowanceType type;

}
