package com.ionecar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ionecar.domain.Vehicle;
import com.ionecar.domain.VehicleDto;
import com.ionecar.service.VehicleService;

@Controller
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public String findAllVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();
        System.out.println("전송된 차량 수: " + vehicles.size());  // 로그로 데이터 확인
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

    /* 
    @GetMapping("/vehicles")
    public String showVehicles(Model model) {
        List<VehicleDto> vehicles = vehicleService.findAllVehiclesWithOptionsAndEtc();
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

    */
}