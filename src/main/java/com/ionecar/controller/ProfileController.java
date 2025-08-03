package com.ionecar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    
    // 딜러 프로필 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showProfilePage(@RequestParam(value = "dealerId", required = false) String dealerId, Model model) {
        // 현재는 하드코딩된 값들로 설정
        // 나중에 DB에서 가져올 예정
        model.addAttribute("dealerId", dealerId);
        model.addAttribute("dealerName", "벤츠박사");
        model.addAttribute("isVerified", "Y"); // 인증 여부 (Y/N)
        model.addAttribute("rating", "5.0");
        model.addAttribute("reviewCount", "67");
        model.addAttribute("quoteCount", "1,416");
        
        return "profile";
    }
} 