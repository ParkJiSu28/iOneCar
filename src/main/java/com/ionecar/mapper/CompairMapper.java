package com.ionecar.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ionecar.domain.Compair;

@Mapper
public interface CompairMapper {
    Compair selectCompairByEdpsCsnAndCarSrn(Long edpsCsn, Long carSrn);
}
