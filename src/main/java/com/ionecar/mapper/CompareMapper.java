package com.ionecar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ionecar.domain.Compare;
import java.util.List;

@Mapper
public interface CompareMapper {
    List<Compare> selectCompareByCarSrn(@Param("carSrn") Long carSrn);
    void updateDealerCarSrn(@Param("carSrn") Long carSrn, @Param("dealerNo") Long dealerNo);
    void updateDealCarSrn(@Param("carSrn") Long carSrn, @Param("dealerNo") Long dealerNo);
}
