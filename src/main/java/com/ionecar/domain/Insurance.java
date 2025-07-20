package com.ionecar.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Insurance {
    private int insuranceId;
    private String edpsCsn;
    private String vehicleId;
    private String company;
    private BigDecimal premium;
    private Date startDate;
}