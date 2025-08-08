package com.ionecar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.ionecar.domain.Dealer;
import com.ionecar.service.DealerService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    
    private final DealerService dealerService;
    
    // 딜러 프로필 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showProfilePage(@RequestParam(value = "dealerNo", required = false) Long dealerNo, Model model) {
        if (dealerNo == null) {
            return "myquote";
        }
        // dealerId로 딜러 정보 조회
        Dealer dealer = dealerService.getDealerByDealerNo(dealerNo);
        
        if (dealer == null) {
            return "myquote";
        }
        
        // 조회된 딜러 정보를 모델에 추가
        model.addAttribute("dealerNo", dealerNo);
        model.addAttribute("dealerName", dealer.getDealerName());
        model.addAttribute("isVerified", dealer.getCertYn()); // 인증 여부 (Y/N)
        model.addAttribute("rating", dealer.getRating());
        model.addAttribute("reviewCount", dealer.getReviewCnt());
        model.addAttribute("quoteCount", dealer.getQuotationCnt());
        
        return "profile";
    }
} 