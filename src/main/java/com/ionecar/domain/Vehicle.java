package com.ionecar.domain;

import lombok.Data;

@Data
public class Vehicle {
    private String vehicleId;
    
    private String modelName;
    private String manufacturer;
    private long basePrice;
    private int modelYear;
    private String fuelType;
}
