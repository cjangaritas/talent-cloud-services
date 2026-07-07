package com.talentcloud.paymentservice.service;

import com.talentcloud.paymentservice.client.HolidayClient;
import com.talentcloud.paymentservice.dto.HolidayDto;
import com.talentcloud.paymentservice.model.PaymentRequest;
import com.talentcloud.paymentservice.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final HolidayClient holidayClient;

    public PaymentService(HolidayClient holidayClient) {
        this.holidayClient = holidayClient;
    }

    public PaymentResponse calculatePayment(PaymentRequest request) {
        boolean isHoliday = false;
        String holidayName = null;
        double rateMultiplier = 1.0;

        try {
            Boolean check = holidayClient.checkIfHoliday(request.date());
            if (Boolean.TRUE.equals(check)) {
                HolidayDto holiday = holidayClient.getHoliday(request.date());
                if (holiday != null) {
                    isHoliday = true;
                    holidayName = holiday.name();
                    rateMultiplier = holiday.rateMultiplier();
                }
            }
        } catch (Exception e) {
            // Log error and fallback to standard rate (1.0)
            System.err.println("Failed to fetch holiday info from holiday-service: " + e.getMessage());
        }

        double calculatedPayment = request.baseDailyRate() * rateMultiplier;

        return new PaymentResponse(
                request.date(),
                request.baseDailyRate(),
                isHoliday,
                holidayName,
                rateMultiplier,
                calculatedPayment
        );
    }
}
