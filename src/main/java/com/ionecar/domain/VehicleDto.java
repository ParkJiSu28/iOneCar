package com.ionecar.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class VehicleDto {
    private String vehicleId;
    private String modelName;
    private String manufacturer;
    private BigDecimal basePrice;
    private int modelYear;
    private String fuelType;
    private List<VehicleOption> options;
    private TaxPayment taxPayment;
    private Insurance insurance;
}