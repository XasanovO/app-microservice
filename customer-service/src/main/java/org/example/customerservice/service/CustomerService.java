package org.example.customerservice.service;


import lombok.RequiredArgsConstructor;
import org.example.clients.fraud.FraudClient;
import org.example.clients.fraud.dto.FraudsterCheckResponse;
import org.example.clients.notification.NotificationClient;
import org.example.customerservice.dto.CustomerDto;
import org.example.customerservice.entity.Customer;
import org.example.customerservice.mappers.CustomerMapper;
import org.example.customerservice.repo.CustomerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitTemplate rabbitTemplate;

    public ResponseEntity<?> saveCustomer(CustomerDto customerDto) {

        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
        FraudsterCheckResponse fraudsterCheckResponse = fraudClient.checkFraudster(customer.getId());
        if (fraudsterCheckResponse.isFraudster()) {
            throw new RuntimeException("this is fraudster");
        }

        rabbitTemplate.convertAndSend("myQueue", "CUSTOMER");

        notificationClient.notification(customer.getFirstName());

        return ResponseEntity.ok(customer);
    }
}
