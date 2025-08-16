package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    /**
     * 대출신청 전 확인사항 페이지
     * @param model 모델
     * @return notice.html 템플릿
     */
    @GetMapping
    public String notice(@RequestParam(value = "carSrn", required = false) Long carSrn,
                        Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        return "notice";
    }
}
