package com.ionecar.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.ionecar.domain.Purchase;

@Mapper
public interface PurchaseMapper {
    void insertPurchase(Purchase purchase);
}
