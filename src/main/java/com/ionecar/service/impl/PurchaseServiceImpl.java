package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Purchase;
import com.ionecar.service.PurchaseService;
import com.ionecar.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService{
    
    private final PurchaseMapper purchaseMapper;

    @Override
    public void insertPurchase(Purchase purchase){
        purchaseMapper.insertPurchase(purchase);
    }
    
}
