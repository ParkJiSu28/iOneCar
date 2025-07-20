package com.ionecar.domain;


import lombok.Data;

@Data
public class Customer {
    private String edpsCsn;
    private String name;
    private String phone;
    private String address;
}