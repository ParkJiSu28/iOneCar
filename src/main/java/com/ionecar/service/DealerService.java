package com.ionecar.service;

import com.ionecar.domain.Dealer;
import com.ionecar.domain.DealerInfo;
import java.util.List;

public interface DealerService {
    List<Dealer> getAllDealers();
    Dealer getDealerByDealerNo(Long dealerNo);
    Dealer getDealerByDealerId(String dealerId);
    List<Dealer> getDealersByCarSrn(Long carSrn);
    List<DealerInfo> getDealerInfoByCarSrn(Long carSrn);
    int createDealer(Dealer dealer);
    int updateDealer(Dealer dealer);
    int deleteDealer(Long dealerNo);
} 