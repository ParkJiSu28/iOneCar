package com.ionecar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;
import com.ionecar.domain.TaxPayment;
import com.ionecar.service.TaxService;

@RestController
@RequestMapping("/api/tax")
@RequiredArgsConstructor
public class TaxController {
    private final TaxService taxService;

    @GetMapping("/{edpsCsn}/{vehicleId}")
    public TaxPayment getTax(@PathVariable String edpsCsn, @PathVariable String vehicleId) {
        return taxService.getTax(edpsCsn, vehicleId);
    }
}
