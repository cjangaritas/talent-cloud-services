package com.talentcloud.paymentservice.dto;

import java.time.LocalDate;

public record HolidayDto(LocalDate date, String name, double rateMultiplier) {}
