package com.uriel.cryptoadvisordemo.controller;

import com.uriel.cryptoadvisordemo.service.AdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @GetMapping("/advice")
    public ResponseEntity<String> generate() {
        return ResponseEntity.ok(
                adviceService.generate()
        );
    }

}
