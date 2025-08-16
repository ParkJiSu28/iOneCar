package com.ionecar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/quote/submit-deal")
@RequiredArgsConstructor
public class SubmitDealController {
    
    // 상담 신청 완료 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showSubmitDealPage(@RequestParam(value = "edpsCsn", required = false) Long edpsCsn, 
                                   HttpSession session, Model model) {
        
        // 1. URL 파라미터에서 edpsCsn 확인
        Long finalEdpsCsn = edpsCsn;
        
        // 2. URL에 edpsCsn이 없으면 세션에서 가져오기
        if (finalEdpsCsn == null) {
            finalEdpsCsn = (Long) session.getAttribute("edpsCsn");
        }
        
        // 3. URL에 edpsCsn이 있으면 세션에 저장 (향후 사용을 위해)
        if (edpsCsn != null) {
            session.setAttribute("edpsCsn", edpsCsn);
        }
        
        // edpsCsn 정보를 모델에 추가하여 내 견적함 버튼에서 사용할 수 있도록 함
        model.addAttribute("edpsCsn", finalEdpsCsn);
        
        return "submit_deal";
    }
} 