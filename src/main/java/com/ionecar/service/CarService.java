package com.ionecar.service;

public interface CarService {
    void insertCar(long edpsCsn);
    void updateCarBrand(long carSrn, String carBrand);
    void updateCarClass(long carSrn, String carClass);
    void updateCarSubClass(long carSrn, String carSubClass); 
    void updateCarInteriorColor(long carSrn, String carInteriorColor);
    void deleteCarByCarSrn(long carSrn);
    void deleteCarByEdpsCsn(long edpsCsn);
}
