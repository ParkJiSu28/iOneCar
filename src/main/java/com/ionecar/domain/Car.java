package com.ionecar.domain;
import lombok.Data;

@Data
public class Car {
    private long edpsCsn;        // 전산고객번호
    private long carSrn;         // 차량번호
    private String carBrand;    // 차량브랜드
    private String carClass;    // 차량클래스
    private String carSubClass; // 차량서브클래스
    private long carPrice;      // 차량가격
    private String carColor;    // 차량색상
    private String carInteriorColor;  // 차량내장색상

}
