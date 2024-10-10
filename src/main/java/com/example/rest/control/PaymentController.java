package com.example.rest.control;

import com.example.rest.exceptions.PaymentException;
import com.example.rest.model.Payment;
import com.example.rest.service.PaymentService;
import com.example.rest.service.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    private Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentService paymentService;

    PaymentException paymentException;

    @GetMapping()
    public ResponseEntity<List<Payment>> getPayments(
            @RequestParam(value = "country", required = false, defaultValue = "") String country
    ) {
        logger.info("Getting payments list. -With country if value is present: {}", country);
        if(!country.isEmpty()) {
            return new ResponseEntity<>(paymentService.getPaymentsByCountry(country), HttpStatus.OK);
        }

        return new ResponseEntity<>(paymentService.getPayments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> getPaymentById (
            @PathVariable Long id ) throws PaymentException {
        return new ResponseEntity<>(paymentService.getPaymentsById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Payment> addNewPayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.addNewPayment(payment), HttpStatus.OK);
    }
}
