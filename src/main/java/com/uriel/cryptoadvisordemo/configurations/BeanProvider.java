package com.uriel.cryptoadvisordemo.configurations;

import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import com.uriel.cryptoadvisordemo.functions.QuotationFunction;
import com.uriel.cryptoadvisordemo.services.QuotationService;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class BeanProvider {

    @Bean
    public FunctionCallback quotationFunction(@Autowired QuotationService quotationService) {
        return FunctionCallbackWrapper.builder(new QuotationFunction(quotationService))
                .withName("CurrentQuotation")
                .withDescription("""
                Get the current quotation of the cryptocurrency by its symbol.
                Available symbols are: %s
                """.formatted(
                        Stream.of(CryptoSymbol.values()).map(CryptoSymbol::name)
                                .collect(Collectors.joining(", "))
                ))
                .build();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
