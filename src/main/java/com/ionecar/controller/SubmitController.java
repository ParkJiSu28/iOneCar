package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.ionecar.service.CustomerService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/quote/submit")
@RequiredArgsConstructor
public class SubmitController {
    
    private final CustomerService customerService;
    
    // 신청완료 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showSubmitString(@RequestParam("carSrn") Long carSrn, HttpSession session, Model model) {
        // 세션에서 edpsCsn 가져오기
        Long edpsCsn = (Long) session.getAttribute("edpsCsn");
        if (edpsCsn != null) {
            // NULL 값 정리 및 qnt_yn 업데이트
            customerService.cleanupNullDataAndUpdateQntYn(edpsCsn);
            model.addAttribute("edpsCsn", edpsCsn);
        }
        
        return "submit";
    }
}