package com.uriel.cryptoadvisordemo.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.quotation")
@Getter
@Setter
public class QuotationProperties {
    private String apiUrl;
}
