package org.example.clients.fraud;


import org.example.clients.fraud.dto.FraudsterCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "fraud-service")
public interface FraudClient {

    @GetMapping("api/fraudster/{customerId}")
    FraudsterCheckResponse checkFraudster(@PathVariable("customerId") Integer customerId);

}
