package com.pauloruszel.hrpayroll.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pauloruszel.hrpayroll.domain.model.Payment;
import com.pauloruszel.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workerId, days);
        if (Objects.nonNull(payment)) {
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("Paulo", 300.0, days);
        return ResponseEntity.ok(payment);
    }
}
