package org.example.fraudservice.repo;


import org.example.fraudservice.entity.Fraudster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudsterRepository extends JpaRepository<Fraudster, Integer> {
}