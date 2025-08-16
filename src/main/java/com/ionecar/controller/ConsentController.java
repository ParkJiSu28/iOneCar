package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/consent")
public class ConsentController {

    /**
     * 약관 및 동의서 페이지
     * @param model 모델
     * @return consent.html 템플릿
     */
    @GetMapping
    public String consent(@RequestParam(value = "carSrn", required = false) Long carSrn,
                         Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        return "consent";
    }

    /**
     * 동의서 정보 저장
     * @param allConsent 전체동의
     * @param personalInfo 개인정보 수집이용제공 동의
     * @param creditInquiry 개인신용정보 조회 동의
     * @param personalDataUsage 개인정보 수집이용제공 동의
     * @param healthInsurance 건강보험공단 조회 동의
     * @param publicMyData 공공마이데이터 조회 동의
     * @param communicationInfo 통신정보 수집이용 동의
     * @param personalCreditConsent 개인신용정보 수집이용 동의
     * @return 결과 JSON
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveConsent(
            @RequestParam(required = false) String allConsent,
            @RequestParam(required = false) String personalInfo,
            @RequestParam(required = false) String creditInquiry,
            @RequestParam(required = false) String personalDataUsage,
            @RequestParam(required = false) String healthInsurance,
            @RequestParam(required = false) String publicMyData,
            @RequestParam(required = false) String communicationInfo,
            @RequestParam(required = false) String personalCreditConsent) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 필수 동의 항목 검증
            if (!"true".equals(personalInfo) || !"true".equals(creditInquiry) || 
                !"true".equals(personalDataUsage) || !"true".equals(healthInsurance) || 
                !"true".equals(publicMyData)) {
                result.put("success", false);
                result.put("message", "필수 동의 항목을 모두 체크해주세요.");
                return result;
            }
            
            // 동의 정보 저장 (실제로는 데이터베이스에 저장)
            Map<String, String> consentData = new HashMap<>();
            consentData.put("allConsent", allConsent);
            consentData.put("personalInfo", personalInfo);
            consentData.put("creditInquiry", creditInquiry);
            consentData.put("personalDataUsage", personalDataUsage);
            consentData.put("healthInsurance", healthInsurance);
            consentData.put("publicMyData", publicMyData);
            consentData.put("communicationInfo", communicationInfo);
            consentData.put("personalCreditConsent", personalCreditConsent);
            
            // 저장 성공
            result.put("success", true);
            result.put("message", "동의 정보가 성공적으로 저장되었습니다.");
            result.put("data", consentData);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "동의 정보 저장 중 오류가 발생했습니다.");
        }
        
        return result;
    }
}
