package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ionecar.service.CarService;
import com.ionecar.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/quote/brand")
@RequiredArgsConstructor
public class BrandController {

    private final CarService carService;
    // 브랜드 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showBrandSelection(HttpSession session) {
        Long edpsCsn = (Long) session.getAttribute("edpsCsn");
        if (edpsCsn == null) {
            // 세션에 값이 없으므로 로그인 화면으로 이동
            return "login";
        }
        
        return "brand";
    }  

    // 브랜드 선택 후 POST 요청을 처리하는 메서드
    @PostMapping
    public String processBrandSelection(@RequestParam("brand") String brand, HttpSession session) {
        Long edpsCsn = (Long) session.getAttribute("edpsCsn");
        if (edpsCsn == null) {
            // 세션에 값이 없으므로 로그인 화면으로 이동
            return "login";
        }
        Car tempCar = new Car();
        tempCar.setEdpsCsn(edpsCsn);
        carService.insertCar(tempCar); // insert 시키기
        Car car = carService.selectInsertedCarByEdpsCsn(edpsCsn);
        Long carSrn = car.getCarSrn();
        carService.updateCarBrand(carSrn,brand);

        
        // 다음 페이지로 리다이렉트 (carSrn을 GET 파라미터로 전달)
        return "redirect:/quote/model?carSrn=" + carSrn;
    }

}
