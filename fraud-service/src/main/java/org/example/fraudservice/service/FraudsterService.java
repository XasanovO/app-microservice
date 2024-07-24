package org.example.fraudservice.service;


import lombok.RequiredArgsConstructor;
import org.example.clients.fraud.dto.FraudsterCheckResponse;
import org.example.fraudservice.entity.Fraudster;
import org.example.fraudservice.repo.FraudsterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudsterService {

    private final FraudsterRepository fraudsterRepository;

    public FraudsterCheckResponse check(Integer customerId) {

        fraudsterRepository.save(
                Fraudster.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .build()
        );

        return new FraudsterCheckResponse(false);
    }
}
