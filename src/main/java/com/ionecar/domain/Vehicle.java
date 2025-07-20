package com.ionecar.domain;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Vehicle {

    private String vehicleId;
    
    private String modelName;
    private String manufacturer;
    private BigDecimal basePrice;
    private int modelYear;
    private String fuelType;

}

