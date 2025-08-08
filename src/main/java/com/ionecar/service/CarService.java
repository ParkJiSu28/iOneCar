package com.ionecar.service;
import com.ionecar.domain.*;

public interface CarService {
    void insertCar(Car car);
    Car  selectInsertedCarByEdpsCsn(long edpsCsn);
    Car  selectCarByCarSrn(long carSrn);
    void updateCarBrand(long carSrn, String carBrand);
    void updateCarClass(long carSrn, String carClass);
    void updateCarSubClass(long carSrn, String carSubClass); 
    void updateCarColor(long carSrn, String carColor);
    void updateCarInteriorColor(long carSrn, String carInteriorColor);
    void updateCarPrice(long carSrn, long carPrice);
    void deleteCarByCarSrn(long carSrn);
    void deleteCarByEdpsCsn(long edpsCsn);
}
