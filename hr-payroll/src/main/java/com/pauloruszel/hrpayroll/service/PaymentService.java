package com.pauloruszel.hrpayroll.service;

import com.pauloruszel.hrpayroll.domain.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Paulo Santos", 200.0, days);
    }
}
