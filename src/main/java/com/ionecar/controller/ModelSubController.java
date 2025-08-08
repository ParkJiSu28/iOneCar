package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Arrays;
import com.ionecar.service.CarService;

@Controller
@RequestMapping("/quote/model_sub")
@RequiredArgsConstructor
public class ModelSubController {

    private final CarService carService;

    // 모델 서브 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showModelSub(@RequestParam("carSrn") Long carSrn, Model model) {
        // carSrn을 모델에 추가하여 뷰에서 사용할 수 있도록 함
        model.addAttribute("carSrn", carSrn);
        return "model_sub";
    }

    // 모델 서브 선택 후 POST 요청을 처리하는 메서드
    @PostMapping
    public String processModelSubSelection(@RequestParam("comboText") String comboText,
                                        @RequestParam("itemName") String itemName,
                                        @RequestParam("price") String price,
                                        @RequestParam("carSrn") Long carSrn) {
        // carSubClass 업데이트: comboText + " " + itemName
        String carSubClass = comboText + " " + itemName;
        carService.updateCarSubClass(carSrn, carSubClass);
        
        // carPrice 업데이트
        long carPrice = Long.parseLong(price);
        carService.updateCarPrice(carSrn, carPrice);
        
        // 다음 페이지로 리다이렉트 (carSrn을 GET 파라미터로 전달)
        return "redirect:/quote/color?carSrn=" + carSrn;
    }

}
