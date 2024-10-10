package com.example.rest.service;

import com.example.rest.exceptions.PaymentException;
import com.example.rest.model.Payment;
import com.example.rest.repository.PaymentRepository;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentsById(Long id) throws PaymentException {
        return Optional.ofNullable(paymentRepository.findById(id).orElseThrow(() -> {

            BigInteger num = new BigInteger(1024, new Random());
            num = num.nextProbablePrime();
            logger.info("The prime is: {} ", num);

            return new PaymentException("No Payment Found");
        }));

    }

    @Override
    public List<Payment> getPaymentsByCountry(String country) {
        return paymentRepository.findAllByCountry(country);
    }

    @Override
    public Payment addNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
