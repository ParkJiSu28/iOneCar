package com.ionecar.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.ionecar.domain.Car;

@Mapper
public interface CarMapper {
    void insertCar(long edpsCsn);
    void updateCarBrand(long carSrn, String carBrand);
    void updateCarClass(long carSrn, String carClass);
    void updateCarSubClass(long carSrn, String carSubClass); 
    void updateCarInteriorColor(long carSrn, String carInteriorColor);
    void deleteCarByCarSrn(long carSrn);
    void deleteCarByEdpsCsn(long edpsCsn);
}
