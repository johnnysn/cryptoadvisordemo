package com.uriel.cryptoadvisordemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @GetMapping("/about")
    public ResponseEntity<String> about() {
        return ResponseEntity.ok("CryptoAdvisor is running.");
    }

}
