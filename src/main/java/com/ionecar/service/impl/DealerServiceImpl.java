package com.ionecar.service.impl;

import com.ionecar.domain.Dealer;
import com.ionecar.domain.DealerInfo;
import com.ionecar.mapper.DealerMapper;
import com.ionecar.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerServiceImpl implements DealerService {
    
    private final DealerMapper dealerMapper;
    
    @Override
    public List<Dealer> getAllDealers() {
        return dealerMapper.selectAllDealers();
    }
    
    @Override
    public Dealer getDealerByDealerNo(Long dealerNo) {
        return dealerMapper.selectDealerByDealerNo(dealerNo);
    }
    
    @Override
    public List<Dealer> getDealersByCarSrn(Long carSrn) {
        return dealerMapper.selectDealersByCarSrn(carSrn);
    }
    
    @Override
    public List<DealerInfo> getDealerInfoByCarSrn(Long carSrn) {
        return dealerMapper.selectDealerInfoByCarSrn(carSrn);
    }
    
    @Override
    public int createDealer(Dealer dealer) {
        return dealerMapper.insertDealer(dealer);
    }
    
    @Override
    public int updateDealer(Dealer dealer) {
        return dealerMapper.updateDealer(dealer);
    }
    
    @Override
    public int deleteDealer(Long dealerNo) {
        return dealerMapper.deleteDealer(dealerNo);
    }
} 