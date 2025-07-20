package com.ionecar.domain;


import lombok.Data;
import java.math.BigDecimal;


@Data
public class VehicleOption {
    private int optionId;
    private String vehicleId;
    private String optionName;
    private BigDecimal optionPrice;
}