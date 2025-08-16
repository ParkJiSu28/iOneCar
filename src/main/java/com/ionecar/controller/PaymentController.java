package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    /**
     * 할부 절차 안내 페이지
     * @param model 모델
     * @return payment.html 템플릿
     */
    @GetMapping
    public String payment(@RequestParam(value = "carSrn", required = false) Long carSrn,
                         Model model) {
        
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        // 기본값으로 설정
        model.addAttribute("edpsCsn", "고객");
        
        return "payment";
    }
}
