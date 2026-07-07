package com.talentcloud.holidayservice.service;

import com.talentcloud.holidayservice.model.Holiday;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    private final List<Holiday> holidays = new ArrayList<>();

    public HolidayService() {
        int year = LocalDate.now().getYear(); // Dynamic year
        
        // Populate standard holidays for the current year
        holidays.add(new Holiday(LocalDate.of(year, 1, 1), "New Year's Day", 2.0));
        holidays.add(new Holiday(LocalDate.of(year, 5, 25), "Memorial Day", 1.5));
        holidays.add(new Holiday(LocalDate.of(year, 7, 4), "Independence Day", 2.0));
        holidays.add(new Holiday(LocalDate.of(year, 9, 7), "Labor Day", 1.5));
        holidays.add(new Holiday(LocalDate.of(year, 11, 26), "Thanksgiving Day", 2.0));
        holidays.add(new Holiday(LocalDate.of(year, 12, 25), "Christmas Day", 2.0));
    }

    public List<Holiday> getAllHolidays() {
        return holidays;
    }

    public Optional<Holiday> getHolidayByDate(LocalDate date) {
        return holidays.stream()
                .filter(holiday -> holiday.date().equals(date))
                .findFirst();
    }

    public boolean isHoliday(LocalDate date) {
        return holidays.stream()
                .anyMatch(holiday -> holiday.date().equals(date));
    }
}
