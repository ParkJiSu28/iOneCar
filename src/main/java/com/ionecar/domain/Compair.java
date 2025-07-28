package com.ionecar.domain;
import lombok.Data;

@Data
public class Compair {
    private Long edpsCsn; // 카멜케이스수정
    private Long carSrn;
    private String carClass;        // ex)  A-Class
    private String carSubClass;   // ex) 2025형 해치백 가솔린
    private String purchaseMethod;    // ex) 할부
    private Long purchasePeriod;         // ex) 48개월
    private Long carPrice;
    private Long optPrice;

}
