package com.ionecar.domain;

import lombok.Data;

@Data
public class DealerInfo {
    private Long dealerNo;
    private String dealerName;
    private String dealerPhone;
    private Long carSrn;
    private Long reviewCnt;
    private Double rating;
    private Long quotationCnt;
    private String certYn;
    private String progress;
    private Double rate;
    private Long discount;
} 