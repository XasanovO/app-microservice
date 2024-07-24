package org.example.fraudservice.controller;


import lombok.RequiredArgsConstructor;
import org.example.clients.fraud.dto.FraudsterCheckResponse;
import org.example.fraudservice.service.FraudsterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraudster")
@RequiredArgsConstructor
public class FraudsterController {

    private final FraudsterService fraudsterService;

    @GetMapping("/{customerId}")
    public FraudsterCheckResponse checkFraudster(@PathVariable("customerId") Integer customerId) {
        return fraudsterService.check(customerId);
    }

}
