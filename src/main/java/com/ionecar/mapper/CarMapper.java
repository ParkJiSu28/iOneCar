package com.ionecar.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ionecar.domain.Car;

@Mapper
public interface CarMapper {
    void insertCar(Car car);
    Car  selectInsertedCarByEdpsCsn(@Param("edpsCsn") long edpsCsn);
    Car  selectCarByCarSrn(@Param("carSrn") long carSrn);
    void updateCarBrand(@Param("carSrn") long carSrn, @Param("carBrand") String carBrand);
    void updateCarClass(@Param("carSrn") long carSrn, @Param("carClass") String carClass);
    void updateCarSubClass(@Param("carSrn") long carSrn, @Param("carSubClass") String carSubClass);
    void updateCarColor(@Param("carSrn") long carSrn, @Param("carColor") String carColor);
    void updateCarInteriorColor(@Param("carSrn") long carSrn, @Param("carInteriorColor") String carInteriorColor);
    void updateCarPrice(@Param("carSrn") long carSrn, @Param("carPrice") long carPrice);
    void deleteCarByCarSrn(@Param("carSrn") long carSrn);
    void deleteCarByEdpsCsn(@Param("edpsCsn") long edpsCsn);
}
