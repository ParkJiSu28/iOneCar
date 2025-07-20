package com.ionecar.service.impl;

import com.ionecar.domain.Insurance;
import com.ionecar.service.InsuranceService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    
    @Override
    public Insurance getInsurance(String edpsCsn, String vehicleId) {
        // 실제 구현은 나중에 추가
        Insurance insurance = new Insurance();
        insurance.setEdpsCsn(edpsCsn);
        insurance.setVehicleId(vehicleId);
        insurance.setCompany("기본 보험사");
        insurance.setPremium(BigDecimal.ZERO);
        insurance.setStartDate(new Date());
        return insurance;
    }
} 