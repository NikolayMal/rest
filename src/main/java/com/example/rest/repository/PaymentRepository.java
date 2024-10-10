package com.example.rest.repository;

import com.example.rest.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findById(Optional<Long> customerId);

    List<Payment> findAllByCountry(String country);
}
