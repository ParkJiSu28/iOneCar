package com.ionecar.service.impl;

import com.ionecar.domain.Vehicle;
import com.ionecar.domain.VehicleDto;
import com.ionecar.domain.VehicleOption;
import com.ionecar.domain.TaxPayment;
import com.ionecar.domain.Insurance;
import com.ionecar.service.VehicleService;
import com.ionecar.mapper.VehicleMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleMapper vehicleMapper;

    @Override
    public List<Vehicle> findAllVehicles() {
        // 단순 차량 목록 조회
        return vehicleMapper.findAllVehicles();
    }
    /* 
    @Override
    public List<VehicleDto> findAllVehiclesWithOptionsAndEtc() {
        // 실제 구현은 나중에 추가
        return vehicleMapper.findAllVehiclesWithOptionsAndEtc();
    }
    */
}