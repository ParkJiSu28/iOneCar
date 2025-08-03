package com.ionecar.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ionecar.domain.Compare;

@Mapper
public interface CompareMapper {
    Compare selectCompareByEdpsCsnAndCarSrn(Long edpsCsn, Long carSrn);
}
