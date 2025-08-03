package com.ionecar.service;

import com.ionecar.domain.Deal;
import java.util.List;

public interface DealService {
    List<Deal> getAllDeals();
    Deal getDealByDealerNoAndCarSrn(Long dealerNo, Long carSrn);
    List<Deal> getDealsByCarSrn(Long carSrn);
    List<Deal> getDealsByDealerNo(Long dealerNo);
    int createDeal(Deal deal);
    int updateDeal(Deal deal);
    int deleteDeal(Long dealerNo, Long carSrn);
} 