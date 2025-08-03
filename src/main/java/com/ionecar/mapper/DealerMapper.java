package com.ionecar.mapper;

import com.ionecar.domain.Dealer;
import com.ionecar.domain.DealerInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DealerMapper {
    List<Dealer> selectAllDealers();
    Dealer selectDealerByDealerNo(Long dealerNo);
    List<Dealer> selectDealersByCarSrn(Long carSrn);
    List<DealerInfo> selectDealerInfoByCarSrn(Long carSrn);
    int insertDealer(Dealer dealer);
    int updateDealer(Dealer dealer);
    int deleteDealer(Long dealerNo);
} 