package com.ionecar.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import com.ionecar.domain.Vehicle;
import com.ionecar.domain.VehicleDto;
import com.ionecar.service.VehicleService;
import com.ionecar.service.CustomerService;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    // 로그인 폼을 반환하는 GET 매핑 추가
    @GetMapping
    public String loginPage() {
        return "login"; // login.html 타임리프 템플릿 반환
    }


    @PostMapping
    public String loginByEdpsCsn(@RequestParam("edps_csn") String edpsCsn, Model model) {
    
        boolean exists = customerService.loginByEdpsCsn(edpsCsn);

        if (exists) {
            return "redirect:/api/vehicles/vehicles";
        } else {
            model.addAttribute("error", "존재하지 않는 고객 번호");
            return "login";
        }
    }
}
