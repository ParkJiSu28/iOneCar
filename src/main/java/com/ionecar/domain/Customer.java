package com.ionecar.domain;


import lombok.Data;

@Data
public class Customer {
    private long edpsCsn; // 전산고객번호
    private String qntYn; // 견적여부
}