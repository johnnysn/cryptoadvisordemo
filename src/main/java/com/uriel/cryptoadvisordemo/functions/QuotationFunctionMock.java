package com.uriel.cryptoadvisordemo.functions;

import com.uriel.cryptoadvisordemo.data.Quotation;
import java.util.function.Function;

public class QuotationFunctionMock implements Function<QuotationFunctionMock.Request, Quotation> {

    public record Request(String cryptoSymbol) {}

    private static final Quotation mockQuotationBTC = new Quotation(
            "BTC",
            "Bitcoin",
            25000,
            26000,
            1317774231.5192668
    );

    private static final Quotation mockQuotationETH = new Quotation(
            "ETH",
            "Ethereum",
            3457.657160793183,
            3456.328189028245,
            2989787847.2354703
    );

    @Override
    public Quotation apply(Request r) {
        if (r.cryptoSymbol.equals("ETH")) {
            return mockQuotationETH;
        }
        return mockQuotationBTC;
    }
}
