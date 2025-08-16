package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.ionecar.service.CarService;

@Controller
@RequestMapping("/quote/color")
@RequiredArgsConstructor
public class ColorController {
    
    private final CarService carService;
    
    // 색상 선택 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showColorSelection(@RequestParam(value = "carSrn", required = false) Long carSrn, Model model) {
        if (carSrn == null) {
            return "redirect:/myquote";
        }
        // carSrn을 모델에 추가하여 뷰에서 사용할 수 있도록 함
        model.addAttribute("carSrn", carSrn);
        return "color";
    }
    
    // 색상 선택 후 POST 요청을 처리하는 메서드
    @PostMapping
    public String processColorSelection(@RequestParam("exteriorColor") String exteriorColor,
                                     @RequestParam("interiorColor") String interiorColor,
                                     @RequestParam("carSrn") Long carSrn) {
        // 외장 색상 업데이트
        carService.updateCarColor(carSrn, exteriorColor);
        
        // 내장 색상 업데이트
        carService.updateCarInteriorColor(carSrn, interiorColor);
        
        // 다음 페이지로 리다이렉트 (carSrn을 GET 파라미터로 전달)
        return "redirect:/quote/option?carSrn=" + carSrn;
    }
}