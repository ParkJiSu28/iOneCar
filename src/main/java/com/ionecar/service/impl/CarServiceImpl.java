package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Car;
import com.ionecar.service.CarService;
import com.ionecar.mapper.CarMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarMapper carMapper;  
    @Override
    public void insertCar(long edpsCsn){
        carMapper.insertCar(edpsCsn);
    }
    @Override
    public void updateCarBrand(long carSrn, String carBrand){
        carMapper.updateCarBrand(carSrn, carBrand);
    }
    @Override
    public void updateCarClass(long carSrn, String carClass){
        carMapper.updateCarClass(carSrn, carClass);
    }
    @Override
    public void updateCarSubClass(long carSrn, String carSubClass){
        carMapper.updateCarSubClass(carSrn, carSubClass);
    }
    @Override
    public void updateCarInteriorColor(long carSrn, String carInteriorColor){
        carMapper.updateCarInteriorColor(carSrn, carInteriorColor);
    }
    @Override
    public void deleteCarByCarSrn(long carSrn){
        carMapper.deleteCarByCarSrn(carSrn);
    }
    @Override
    public void deleteCarByEdpsCsn(long edpsCsn){
        carMapper.deleteCarByEdpsCsn(edpsCsn);
    }
}
