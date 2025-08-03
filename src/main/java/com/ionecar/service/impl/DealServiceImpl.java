package com.ionecar.service.impl;

import com.ionecar.domain.Deal;
import com.ionecar.mapper.DealMapper;
import com.ionecar.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {
    
    private final DealMapper dealMapper;
    
    @Override
    public List<Deal> getAllDeals() {
        return dealMapper.selectAllDeals();
    }
    
    @Override
    public Deal getDealByDealerNoAndCarSrn(Long dealerNo, Long carSrn) {
        return dealMapper.selectDealByDealerNoAndCarSrn(dealerNo, carSrn);
    }
    
    @Override
    public List<Deal> getDealsByCarSrn(Long carSrn) {
        return dealMapper.selectDealsByCarSrn(carSrn);
    }
    
    @Override
    public List<Deal> getDealsByDealerNo(Long dealerNo) {
        return dealMapper.selectDealsByDealerNo(dealerNo);
    }
    
    @Override
    public int createDeal(Deal deal) {
        return dealMapper.insertDeal(deal);
    }
    
    @Override
    public int updateDeal(Deal deal) {
        return dealMapper.updateDeal(deal);
    }
    
    @Override
    public int deleteDeal(Long dealerNo, Long carSrn) {
        return dealMapper.deleteDeal(dealerNo, carSrn);
    }
} 