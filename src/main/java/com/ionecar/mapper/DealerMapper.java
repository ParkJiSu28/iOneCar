package com.ionecar.mapper;

import com.ionecar.domain.Dealer;
import com.ionecar.domain.DealerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DealerMapper {
    List<Dealer> selectAllDealers();
    Dealer selectDealerByDealerNo(@Param("dealerNo") Long dealerNo);
    Dealer selectDealerByDealerId(@Param("dealerId") String dealerId);
    List<Dealer> selectDealersByCarSrn(@Param("carSrn") Long carSrn);
    List<DealerInfo> selectDealerInfoByCarSrn(@Param("carSrn") Long carSrn);
    int insertDealer(Dealer dealer);
    int updateDealer(Dealer dealer);
    int deleteDealer(@Param("dealerNo") Long dealerNo);
} 