package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Compare;
import com.ionecar.service.CompareSerivce;
import com.ionecar.mapper.CompareMapper;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompareServiceImpl implements CompareSerivce {
    private final CompareMapper compareMapper;

    @Override
    public List<Compare> selectCompareByCarSrn(Long carSrn) {
        List<Compare> compares = compareMapper.selectCompareByCarSrn(carSrn);
        
        // 각 Compare 객체에 대해 월납입료 계산
        for (Compare compare : compares) {
            compare.setMonthlyPayment(compare.calculateMonthlyPayment());
        }
        
        return compares;
    }

    @Override
    public void updateDealerCarSrn(Long carSrn, Long dealerNo) {
        compareMapper.updateDealerCarSrn(carSrn, dealerNo);
    }

    @Override
    public void updateDealCarSrn(Long carSrn, Long dealerNo) {
        compareMapper.updateDealCarSrn(carSrn, dealerNo);
    }
}
