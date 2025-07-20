package com.ionecar.service;

import com.ionecar.domain.Vehicle;
import java.util.List;

public interface VehicleService {
    List<Vehicle> findAllVehicles();
    //List<VehicleDto> findAllVehiclesWithOptionsAndEtc();
} 