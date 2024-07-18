package com.uriel.cryptoadvisordemo.services;

import com.uriel.cryptoadvisordemo.configurations.QuotationProperties;
import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import com.uriel.cryptoadvisordemo.data.Quotation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuotationService {

    private final RestTemplate restTemplate;
    private final QuotationProperties props;

    public Quotation fetch(CryptoSymbol cryptoSymbol) {
        Map<String, Object> responseMap = restTemplate.getForObject(
                props.getApiUrl() + "/" + cryptoSymbol.name(), Map.class
        );

        if (responseMap == null) throw new RuntimeException("Could not fetch quotation");

        return new Quotation(
                (String) responseMap.get("Symbol"),
                (String) responseMap.get("Name"),
                (Double) responseMap.get("Price"),
                (Double) responseMap.get("PriceYesterday"),
                (Double) responseMap.get("VolumeYesterdayUSD")
        );
    }
}
