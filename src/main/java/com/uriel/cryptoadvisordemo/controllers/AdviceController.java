package com.uriel.cryptoadvisordemo.controllers;

import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import com.uriel.cryptoadvisordemo.data.Question;
import com.uriel.cryptoadvisordemo.services.AdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @GetMapping("/advice/overview/{cryptoSymbol}")
    public ResponseEntity<String> generate(
            @PathVariable CryptoSymbol cryptoSymbol
    ) {
        return ResponseEntity.ok(adviceService.overview(cryptoSymbol));
    }

    @PostMapping("/advice/question")
    public ResponseEntity<String> generate(@RequestBody Question question) {
        return ResponseEntity.ok(adviceService.answer(question.text()));
    }
}
