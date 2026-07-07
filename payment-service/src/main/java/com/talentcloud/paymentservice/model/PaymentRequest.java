package com.talentcloud.paymentservice.model;

import java.time.LocalDate;

public record PaymentRequest(double baseDailyRate, LocalDate date) {}
