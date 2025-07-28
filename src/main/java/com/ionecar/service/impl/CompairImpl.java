package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Compair;
import com.ionecar.service.CompairSerivce;
import com.ionecar.mapper.CompairMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompairImpl implements CompairSerivce {
    private final CompairMapper compairMapper;

    @Override
    public Compair selectCompairByEdpsCsnAndCarSrn(Long edpsCsn, Long carSrn) {
        return compairMapper.selectCompairByEdpsCsnAndCarSrn(edpsCsn, carSrn);
    }
}
