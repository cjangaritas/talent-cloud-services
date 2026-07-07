package com.talentcloud.paymentservice.model;

import java.time.LocalDate;

public record PaymentResponse(
    LocalDate date,
    double baseDailyRate,
    boolean isHoliday,
    String holidayName,
    double rateMultiplier,
    double calculatedPayment
) {}
