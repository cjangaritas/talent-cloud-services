package com.talentcloud.holidayservice.model;

import java.time.LocalDate;

public record Holiday(LocalDate date, String name, double rateMultiplier) {}
