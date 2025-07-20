package com.ionecar.service.impl;

import com.ionecar.domain.VehicleOption;
import com.ionecar.service.VehicleOptionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class VehicleOptionServiceImpl implements VehicleOptionService {
    
    @Override
    public List<VehicleOption> getOptionsByVehicle(String vehicleId) {
        // 실제 구현은 나중에 추가
        return new ArrayList<>();
    }
} 