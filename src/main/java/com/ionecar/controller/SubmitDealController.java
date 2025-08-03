package com.ionecar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/quote/submit-deal")
@RequiredArgsConstructor
public class SubmitDealController {
    
    // 상담 신청 완료 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showSubmitDealPage(@RequestParam(value = "edpsCsn", required = false) Long edpsCsn, Model model) {
        // edpsCsn 정보를 모델에 추가하여 내 견적함 버튼에서 사용할 수 있도록 함
        model.addAttribute("edpsCsn", edpsCsn);
        return "submit_deal";
    }
} 