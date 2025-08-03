package com.ionecar.domain;

import lombok.Data;

@Data
public class Dealer {
    private Long dealerNo;
    private String dealerName;
    private String dealerPhone;
    private Long carSrn;
    private Long reviewCnt;
    private Double rating;
    private Long quotationCnt;
    private String certYn;
} 