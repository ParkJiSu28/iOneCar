package com.ionecar.domain;

import lombok.Data;

@Data
public class Purchase {
  private long carSrn; // 차량번호
  private String purchaseMethod; // 구매방법
  private long purchasePeriod; // 할부기간
  private long purchaseAdvance; // 선수금
  private String purchaseLocation; // 인수지역
  private String purchaseDutyFree; // 면세여부
  private String financeName; // 금융회사명
  private double financeRate; // 금리

}
