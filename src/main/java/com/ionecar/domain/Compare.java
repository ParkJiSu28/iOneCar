package com.ionecar.domain;
import lombok.Data;

@Data
public class Compare {
    private Long edpsCsn; // 카멜케이스수정
    private Long carSrn;
    private String carClass;        // ex)  A-Class
    private String carSubClass;   // ex) 2025형 해치백 가솔린
    private String purchaseMethod;    // ex) 할부
    private Long purchasePeriod;         // ex) 48개월
    private Long carPrice;
    private Long optPrice;
    
    // Dealer 관련 필드
    private String dealerName;
    private Long dealerNo;
    private Double rating;
    private Long reviewCnt;
    private Long quotationCnt;
    
    // Deal 관련 필드
    private Long discount;
    private Double rate;
    private String progress;
    
    // 계산된 필드
    private Long monthlyPayment;
    
    // 월납입료 계산 메서드
    public Long calculateMonthlyPayment() {
        if (carPrice == null || optPrice == null || discount == null || rate == null || purchasePeriod == null) {
            return 0L;
        }
        
        long totalPrice = carPrice + optPrice;
        long discountedPrice = totalPrice - discount;
        double monthlyRate = 1+rate/100; // 연이율을 월이율로 변환
        
        if (monthlyRate == 0) {
            return discountedPrice / purchasePeriod;
        }
        
        double numerator = discountedPrice * monthlyRate;
        
        return Math.round(numerator / purchasePeriod);
    }
}
