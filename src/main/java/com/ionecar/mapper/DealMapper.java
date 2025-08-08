package com.ionecar.mapper;

import com.ionecar.domain.Deal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DealMapper {
    List<Deal> selectAllDeals();
    Deal selectDealByDealerNoAndCarSrn(@Param("dealerNo") Long dealerNo, @Param("carSrn") Long carSrn);
    List<Deal> selectDealsByCarSrn(@Param("carSrn") Long carSrn);
    List<Deal> selectDealsByDealerNo(@Param("dealerNo") Long dealerNo);
    int insertDeal(Deal deal);
    int updateDeal(Deal deal);
    int deleteDeal(@Param("dealerNo") Long dealerNo, @Param("carSrn") Long carSrn);
} 