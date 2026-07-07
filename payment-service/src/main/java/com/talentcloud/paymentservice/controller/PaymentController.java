package com.talentcloud.paymentservice.controller;

import com.talentcloud.paymentservice.model.PaymentRequest;
import com.talentcloud.paymentservice.model.PaymentResponse;
import com.talentcloud.paymentservice.service.PaymentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<PaymentResponse> calculatePaymentBody(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.calculatePayment(request));
    }

    @GetMapping("/calculate")
    public ResponseEntity<PaymentResponse> calculatePaymentGet(
            @RequestParam double baseDailyRate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        PaymentRequest request = new PaymentRequest(baseDailyRate, date);
        return ResponseEntity.ok(paymentService.calculatePayment(request));
    }
}
