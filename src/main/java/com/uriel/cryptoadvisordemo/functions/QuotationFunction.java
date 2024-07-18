package com.uriel.cryptoadvisordemo.functions;

import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import com.uriel.cryptoadvisordemo.data.Quotation;
import com.uriel.cryptoadvisordemo.services.QuotationService;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class QuotationFunction implements Function<QuotationFunction.Request, Quotation> {

    private final QuotationService quotationService;

    public record Request(String cryptoSymbol) {}

    @Override
    public Quotation apply(Request r) {
        return quotationService.fetch(CryptoSymbol.valueOf(r.cryptoSymbol()));
    }
}
