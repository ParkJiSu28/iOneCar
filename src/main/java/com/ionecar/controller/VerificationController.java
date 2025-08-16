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
@RequestMapping("/verification")
public class VerificationController {

    /**
     * 적합성·적정성 고객정보 확인서 작성 페이지
     * @param model 모델
     * @return verification.html 템플릿
     */
    @GetMapping
    public String verification(@RequestParam(value = "carSrn", required = false) Long carSrn,
                             Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        // 고객 정보 (실제로는 세션이나 데이터베이스에서 가져와야 함)
        Map<String, String> customerInfo = new HashMap<>();
        customerInfo.put("email", "ibk1234@gmail.com");
        customerInfo.put("consumerType", "일반금융 소비자");
        customerInfo.put("age", "42세");
        
        model.addAttribute("customerInfo", customerInfo);
        return "verification";
    }
    
    /**
     * 적합성·적정성 고객정보 확인 결과 페이지
     * @param model 모델
     * @return verification_check.html 템플릿
     */
    @GetMapping("/check")
    public String verificationCheck(@RequestParam(value = "carSrn", required = false) Long carSrn,
                                  Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        // 고객 정보 (실제로는 세션이나 데이터베이스에서 가져와야 함)
        Map<String, String> customerInfo = new HashMap<>();
        customerInfo.put("email", "abc123@naver.com");
        customerInfo.put("consumerType", "일반금융 소비자");
        customerInfo.put("age", "48세");
        
        model.addAttribute("customerInfo", customerInfo);
        return "verification_check";
    }
    
    /**
     * 적합성 평가 결과 조회
     * @param loanPurpose 대출용도
     * @param assets 보유자산
     * @param income 현재소득
     * @param futureIncome 미래예상소득
     * @param debt 부채
     * @param fixedExpense 고정지출
     * @param creditHistory 연체정보
     * @param creditScore 신용점수
     * @param evaluationStandard 평가기관
     * @param repaymentMethod 변제방법
     * @return 평가 결과 JSON
     */
    @PostMapping("/evaluate")
    @ResponseBody
    public Map<String, Object> evaluateCustomer(
            @RequestParam String loanPurpose,
            @RequestParam String assets,
            @RequestParam String income,
            @RequestParam String futureIncome,
            @RequestParam String debt,
            @RequestParam String fixedExpense,
            @RequestParam String creditHistory,
            @RequestParam String creditScore,
            @RequestParam String evaluationStandard,
            @RequestParam String repaymentMethod) {
        
        Map<String, Object> result = new HashMap<>();
        
        // 간단한 적합성 평가 로직 (실제로는 복잡한 비즈니스 로직이 필요)
        boolean isEligible = evaluateEligibility(loanPurpose, assets, income, 
                                                 futureIncome, debt, fixedExpense, 
                                                 creditHistory, creditScore);
        
        result.put("eligible", isEligible);
        result.put("message", isEligible ? "적합(대출신청가능)" : "부적합(추가검토필요)");
        result.put("loanPurpose", loanPurpose);
        result.put("assets", assets);
        result.put("income", income);
        result.put("futureIncome", futureIncome);
        result.put("debt", debt);
        result.put("fixedExpense", fixedExpense);
        result.put("creditHistory", creditHistory);
        result.put("creditScore", creditScore);
        result.put("evaluationStandard", evaluationStandard);
        result.put("repaymentMethod", repaymentMethod);
        
        return result;
    }
    
    /**
     * 적합성 평가 로직
     */
    private boolean evaluateEligibility(String loanPurpose, String assets, String income,
                                      String futureIncome, String debt, String fixedExpense,
                                      String creditHistory, String creditScore) {
        // 기본적으로 자동차구입 목적이고, 연체정보가 없으면 적합으로 판단
        if ("other".equals(loanPurpose) && "noDelay".equals(creditHistory)) {
            return true;
        }
        
        // 추가적인 평가 기준들...
        // 실제로는 더 복잡한 로직이 필요
        
        return false;
    }
}
