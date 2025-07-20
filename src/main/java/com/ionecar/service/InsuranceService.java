package com.ionecar.service;

import com.ionecar.domain.Insurance;

public interface InsuranceService {
    Insurance getInsurance(String edpsCsn, String vehicleId);
} 