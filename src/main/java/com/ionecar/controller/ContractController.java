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
@RequestMapping("/contract")
public class ContractController {

    /**
     * 할부약정 페이지
     * @param carSrn 차량 시리얼 번호
     * @param model 모델
     * @return contract.html 템플릿
     */
    @GetMapping
    public String contract(@RequestParam(value = "carSrn", required = false) Long carSrn,
                          Model model) {
        // carSrn을 모델에 추가
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        
        return "contract";
    }

    /**
     * 계약 동의 정보 저장
     * @param carSrn 차량 시리얼 번호
     * @param allConsent 전체동의
     * @param loanProductGuide 가계대출상품설명서
     * @param basicTerms 은행여신거래기본약관
     * @param installmentAgreement 할부거래약정서
     * @param accountAutoTransfer 계좌자동이체약관
     * @param interestRateReduction 금리인하요구권 안내
     * @param productConfirm1 상품설명서 확인사항 1
     * @param productConfirm2 상품설명서 확인사항 2
     * @param productConfirm3 상품설명서 확인사항 3
     * @param productConfirm4 상품설명서 확인사항 4
     * @param preConsentTerms 할부거래약정서 동의
     * @param accountTerms 계좌자동이체약관 동의
     * @param interestTerms 금리인하요구권 안내 확인서 동의
     * @return 결과 JSON
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveContract(
            @RequestParam(value = "carSrn", required = false) Long carSrn,
            @RequestParam(required = false) String allConsent,
            @RequestParam(required = false) String loanProductGuide,
            @RequestParam(required = false) String basicTerms,
            @RequestParam(required = false) String installmentAgreement,
            @RequestParam(required = false) String accountAutoTransfer,
            @RequestParam(required = false) String interestRateReduction,
            @RequestParam(required = false) String productConfirm1,
            @RequestParam(required = false) String productConfirm2,
            @RequestParam(required = false) String productConfirm3,
            @RequestParam(required = false) String productConfirm4,
            @RequestParam(required = false) String preConsentTerms,
            @RequestParam(required = false) String accountTerms,
            @RequestParam(required = false) String interestTerms) {
        
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 필수 동의 항목 검증
            if (!"true".equals(loanProductGuide) || !"true".equals(basicTerms) || 
                !"true".equals(installmentAgreement) || !"true".equals(accountAutoTransfer) || 
                !"true".equals(interestRateReduction)) {
                result.put("success", false);
                result.put("message", "필수 동의 항목을 모두 체크해주세요.");
                return result;
            }
            
            // 상품설명서 확인사항 검증
            if (!"true".equals(productConfirm1) || !"true".equals(productConfirm2) || 
                !"true".equals(productConfirm3) || !"true".equals(productConfirm4)) {
                result.put("success", false);
                result.put("message", "상품설명서 확인사항을 모두 체크해주세요.");
                return result;
            }
            
            // 가입전 동의사항 검증
            if (!"true".equals(preConsentTerms) || !"true".equals(accountTerms) || 
                !"true".equals(interestTerms)) {
                result.put("success", false);
                result.put("message", "가입전 동의사항을 모두 체크해주세요.");
                return result;
            }
            
            // 계약 정보 저장 (실제로는 데이터베이스에 저장)
            Map<String, Object> contractData = new HashMap<>();
            contractData.put("carSrn", carSrn);
            contractData.put("allConsent", allConsent);
            contractData.put("loanProductGuide", loanProductGuide);
            contractData.put("basicTerms", basicTerms);
            contractData.put("installmentAgreement", installmentAgreement);
            contractData.put("accountAutoTransfer", accountAutoTransfer);
            contractData.put("interestRateReduction", interestRateReduction);
            contractData.put("productConfirm1", productConfirm1);
            contractData.put("productConfirm2", productConfirm2);
            contractData.put("productConfirm3", productConfirm3);
            contractData.put("productConfirm4", productConfirm4);
            contractData.put("preConsentTerms", preConsentTerms);
            contractData.put("accountTerms", accountTerms);
            contractData.put("interestTerms", interestTerms);
            
            // 저장 성공
            result.put("success", true);
            result.put("message", "계약 정보가 성공적으로 저장되었습니다.");
            result.put("data", contractData);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "계약 정보 저장 중 오류가 발생했습니다.");
        }
        
        return result;
    }
}
