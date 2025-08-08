package com.ionecar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Param;
import com.ionecar.domain.Customer;

@Mapper
public interface CustomerMapper {
  
    Customer findCustomerByEdpsCsn(@Param("edpsCsn") long edpsCsn);
    Customer getCustomerByEdpsCsn(@Param("edpsCsn") long edpsCsn);
    void deleteCustomerByEdpsCsn(@Param("edpsCsn") long edpsCsn);
    void updateQntYn(@Param("edpsCsn") long edpsCsn, @Param("qntYn") String qntYn);
    void updateQntYnByCarSrn(@Param("carSrn") long carSrn, @Param("qntYn") String qntYn);
    void deleteNullCars(@Param("edpsCsn") long edpsCsn);
    void deleteOrphanedOptions();
    void deleteOrphanedPurchases();
    void updateQntYnBasedOnCompleteData(@Param("edpsCsn") long edpsCsn);
}


