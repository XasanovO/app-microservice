package org.example.customerservice.dto;

import lombok.Value;
import org.example.customerservice.entity.Customer;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
@Value
public class CustomerDto implements Serializable {
    String email;
    String firstName;
    String lastName;
}