package com.ionecar.service.impl;

import com.ionecar.domain.TaxPayment;
import com.ionecar.service.TaxService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TaxServiceImpl implements TaxService {
    
    @Override
    public TaxPayment getTax(String edpsCsn, String vehicleId) {
        // 실제 구현은 나중에 추가
        TaxPayment taxPayment = new TaxPayment();
        taxPayment.setEdpsCsn(edpsCsn);
        taxPayment.setVehicleId(vehicleId);
        taxPayment.setAmount(BigDecimal.ZERO);
        return taxPayment;
    }
} 