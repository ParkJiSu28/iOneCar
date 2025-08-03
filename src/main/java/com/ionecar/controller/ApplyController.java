package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/quote/apply")
@RequiredArgsConstructor
public class ApplyController {
    // 견적확인 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showApplyString() {
        return "apply";
    }
    
    // 견적신청 폼 제출 처리
    @PostMapping
    public String submitApply(
            @RequestParam(value = "nonFaceToFace", required = false) String nonFaceToFace,
            @RequestParam(value = "accessoryService", required = false) String accessoryService,
            @RequestParam(value = "contractIntent", required = false) String contractIntent,
            @RequestParam(value = "requestContent", required = false) String requestContent) {
        
        // 여기서 폼 데이터를 처리하고 데이터베이스에 저장하는 로직을 추가할 수 있습니다.
        // 현재는 단순히 submit 페이지로 리다이렉트합니다.
        
        return "redirect:/quote/submit";
    }
}