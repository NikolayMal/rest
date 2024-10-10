package com.example.rest.service;

import com.example.rest.exceptions.PaymentException;
import com.example.rest.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> getPayments();

    Optional<Payment> getPaymentsById(Long id) throws PaymentException;

    List<Payment> getPaymentsByCountry(String country);

    Payment addNewPayment(Payment payment);
}
