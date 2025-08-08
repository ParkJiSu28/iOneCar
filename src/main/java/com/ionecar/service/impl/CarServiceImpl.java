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
    public void insertCar(Car car){
        carMapper.insertCar(car);
    }
    @Override
    public Car selectInsertedCarByEdpsCsn(long edpsCsn){
        Car car = carMapper.selectInsertedCarByEdpsCsn(edpsCsn);
        return car;
    } 
    @Override
    public Car selectCarByCarSrn(long carSrn){
        Car car = carMapper.selectCarByCarSrn(carSrn);
        return car;
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
    public void updateCarColor(long carSrn, String carColor){
        carMapper.updateCarColor(carSrn, carColor);
    }
    @Override
    public void updateCarInteriorColor(long carSrn, String carInteriorColor){
        carMapper.updateCarInteriorColor(carSrn, carInteriorColor);
    }
    @Override
    public void updateCarPrice(long carSrn, long carPrice){
        carMapper.updateCarPrice(carSrn, carPrice);
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
