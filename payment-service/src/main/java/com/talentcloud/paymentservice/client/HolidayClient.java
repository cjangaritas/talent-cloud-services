package com.talentcloud.paymentservice.client;

import com.talentcloud.paymentservice.dto.HolidayDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "holiday-service")
public interface HolidayClient {

    @GetMapping("/api/holidays/{date}")
    HolidayDto getHoliday(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @GetMapping("/api/holidays/check")
    Boolean checkIfHoliday(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
