package com.ionecar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;
import com.ionecar.domain.Insurance;
import com.ionecar.service.InsuranceService;

@RestController
@RequestMapping("/api/insurance")
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping("/{edpsCsn}/{vehicleId}")
    public Insurance getInsurance(@PathVariable String edpsCsn, @PathVariable String vehicleId) {
        return insuranceService.getInsurance(edpsCsn, vehicleId);
    }
}