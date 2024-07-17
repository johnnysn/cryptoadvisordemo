package com.uriel.cryptoadvisordemo.controllers;

import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import com.uriel.cryptoadvisordemo.services.AdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @GetMapping("/advice")
    public ResponseEntity<String> generate(
            @RequestParam(required = false, defaultValue = "BTC") CryptoSymbol cryptoSymbol
    ) {
        return ResponseEntity.ok(adviceService.generate(cryptoSymbol));
    }
}
