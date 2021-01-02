package com.pauloruszel.hrpayroll.service;

import com.pauloruszel.hrpayroll.domain.model.Payment;
import com.pauloruszel.hrpayroll.domain.model.Worker;
import com.pauloruszel.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        final Worker worker = workerFeignClient.findById(workerId).getBody();
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }


}
