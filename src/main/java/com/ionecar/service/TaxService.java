package com.ionecar.service;

import com.ionecar.domain.TaxPayment;

public interface TaxService {
    TaxPayment getTax(String edpsCsn, String vehicleId);
} 