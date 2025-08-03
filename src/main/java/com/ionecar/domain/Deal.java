package com.ionecar.domain;

import lombok.Data;

@Data
public class Deal {
    private Long dealerNo;
    private Long carSrn;
    private String progress;
    private Double rate;
    private Long discount;
} 