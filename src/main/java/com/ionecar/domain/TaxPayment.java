package com.ionecar.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TaxPayment {
    private int taxId;
    private String edpsCsn;
    private String vehicleId;
    private BigDecimal amount;
    private Date paymentDate;
}