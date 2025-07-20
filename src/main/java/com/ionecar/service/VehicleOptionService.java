package com.ionecar.service;

import com.ionecar.domain.VehicleOption;
import java.util.List;

public interface VehicleOptionService {
    List<VehicleOption> getOptionsByVehicle(String vehicleId);
} 