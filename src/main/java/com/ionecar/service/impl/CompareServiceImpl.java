package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Compare;
import com.ionecar.service.CompareSerivce;
import com.ionecar.mapper.CompareMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompareServiceImpl implements CompareSerivce {
    private final CompareMapper compareMapper;

    @Override
    public Compare selectCompareByEdpsCsnAndCarSrn(Long edpsCsn, Long carSrn) {
        return compareMapper.selectCompareByEdpsCsnAndCarSrn(edpsCsn, carSrn);
    }
}
