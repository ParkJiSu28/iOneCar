package com.ionecar.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ionecar.domain.Purchase;

@Mapper
public interface PurchaseMapper {
    void insertPurchase(Purchase purchase);
    Purchase selectPurchaseByCarSrn(@Param("carSrn") long carSrn);
}
