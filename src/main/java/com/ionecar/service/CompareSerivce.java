package com.ionecar.service;

import com.ionecar.domain.Compare;
import java.util.List;

public interface CompareSerivce {
    List<Compare> selectCompareByCarSrn(Long carSrn);
    void updateDealerCarSrn(Long carSrn, Long dealerNo);
    void updateDealCarSrn(Long carSrn, Long dealerNo);
}
