package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    /**
     * 대출신청 전 확인사항 페이지
     * @param model 모델
     * @return notice.html 템플릿
     */
    @GetMapping
    public String notice(Model model) {
        return "notice";
    }
}
