package com.ionecar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ionecar.domain.VehicleOption;
import com.ionecar.service.VehicleOptionService;

@RestController
@RequestMapping("/api/vehicle-options")
@RequiredArgsConstructor
public class VehicleOptionController {
    private final VehicleOptionService vehicleOptionService;

    @GetMapping("/{vehicleId}")
    public List<VehicleOption> getOptionsByVehicle(@PathVariable String vehicleId) {
        return vehicleOptionService.getOptionsByVehicle(vehicleId);
    }
}