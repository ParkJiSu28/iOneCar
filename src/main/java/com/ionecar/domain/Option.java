package com.ionecar.domain;
import lombok.Data;

@Data
public class Option {
    private long carSrn; // 차량번호
    private long optSrn; // 옵션번호
    private String optName; // 옵션명
    private long optPrice; // 옵션가격
    private String optdef; // 옵션설명
}
