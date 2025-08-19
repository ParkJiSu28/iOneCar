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
@RequestMapping("/application")
public class ApplicationController {

    /**
     * 대출 신청서 페이지
     * @param carSrn 차량 시리얼 번호
     * @param model 모델
     * @return application.html 템플릿
     */
    @GetMapping
    public String application(@RequestParam(value = "carSrn", required = false) Long carSrn,
                             Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        // 기본 고객 정보 (실제로는 DB에서 가져옴)
        Map<String, Object> customerInfo = new HashMap<>();
        customerInfo.put("name", "홍길동");
        customerInfo.put("email", "ibk1234@gmail.com");
        customerInfo.put("phone", "010-1234-5678");
        
        model.addAttribute("customerInfo", customerInfo);
        
        return "application";
    }

    /**
     * 대출 신청 정보 확인 페이지
     * @param carSrn 차량 시리얼 번호
     * @param model 모델
     * @return application_check.html 템플릿
     */
    @GetMapping("/check")
    public String applicationCheck(@RequestParam(value = "carSrn", required = false) Long carSrn,
                                  Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        // 기본 고객 정보 (실제로는 DB에서 가져옴)
        Map<String, Object> customerInfo = new HashMap<>();
        customerInfo.put("name", "김기은");
        customerInfo.put("email", "ibk1234@gmail.com");
        customerInfo.put("phone", "010-1234-5678");
        customerInfo.put("cardNumber", "9440-0323-5454-1112");
        
        model.addAttribute("customerInfo", customerInfo);
        
        return "application_check";
    }

    /**
     * 대출 신청 정보 저장
     * @param carSrn 차량 시리얼 번호
     * @param cardType 카드 종류
     * @param installmentPeriod 할부 기간
     * @param paymentDay 할부 상환일
     * @param notificationMethod 할부 상환 통지 방법
     * @param employeeRecommendation 권유 직원 여부
     * @param employeeName 직원명 (선택)
     * @return 결과 JSON
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveApplication(
            @RequestParam(value = "carSrn", required = false) Long carSrn,
            @RequestParam String cardType,
            @RequestParam String installmentPeriod,
            @RequestParam String paymentDay,
            @RequestParam String notificationMethod,
            @RequestParam(required = false) String employeeRecommendation,
            @RequestParam(required = false) String employeeName) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 필수 입력 항목 검증
            if (cardType == null || cardType.trim().isEmpty() ||
                installmentPeriod == null || installmentPeriod.trim().isEmpty() ||
                paymentDay == null || paymentDay.trim().isEmpty() ||
                notificationMethod == null || notificationMethod.trim().isEmpty()) {
                
                result.put("success", false);
                result.put("message", "필수 입력 항목을 모두 입력해주세요.");
                return result;
            }
            
            // 권유직원 체크 시 직원명 입력 검증
            if ("true".equals(employeeRecommendation) && 
                (employeeName == null || employeeName.trim().isEmpty())) {
                result.put("success", false);
                result.put("message", "권유직원을 선택하신 경우 지점 또는 직원명을 입력해주세요.");
                return result;
            }
            
            // 신청 정보 저장 (실제로는 데이터베이스에 저장)
            Map<String, Object> applicationData = new HashMap<>();
            applicationData.put("carSrn", carSrn);
            applicationData.put("cardType", cardType);
            applicationData.put("installmentPeriod", installmentPeriod);
            applicationData.put("paymentDay", paymentDay);
            applicationData.put("notificationMethod", notificationMethod);
            applicationData.put("employeeRecommendation", employeeRecommendation);
            applicationData.put("employeeName", employeeName);
            
            // 저장 성공
            result.put("success", true);
            result.put("message", "신청 정보가 성공적으로 저장되었습니다.");
            result.put("data", applicationData);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "신청 정보 저장 중 오류가 발생했습니다.");
        }
        
        return result;
    }

    /**
     * IBK 신용카드 목록 조회
     * @return 카드 목록 JSON
     */
    @GetMapping("/cards")
    @ResponseBody
    public Map<String, Object> getIbkCards() {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // IBK 신용카드 목록 (실제로는 DB에서 조회)
            String[] cardList = {
                "IBK 일상의 기쁨카드(신용)",
                "IBK 체크카드 PLUS",
                "IBK 기업우대카드(신용)",
                "IBK 자유로이카드(신용)",
                "IBK 다담카드(신용)",
                "IBK 여행가는날카드(신용)"
            };
            
            result.put("success", true);
            result.put("cards", cardList);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "카드 목록 조회 중 오류가 발생했습니다.");
        }
        
        return result;
    }
}
