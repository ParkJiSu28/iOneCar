package com.ionecar.mapper;

import com.ionecar.domain.Deal;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DealMapper {
    List<Deal> selectAllDeals();
    Deal selectDealByDealerNoAndCarSrn(Long dealerNo, Long carSrn);
    List<Deal> selectDealsByCarSrn(Long carSrn);
    List<Deal> selectDealsByDealerNo(Long dealerNo);
    int insertDeal(Deal deal);
    int updateDeal(Deal deal);
    int deleteDeal(Long dealerNo, Long carSrn);
} 