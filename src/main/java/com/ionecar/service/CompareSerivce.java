package com.ionecar.service;

import com.ionecar.domain.Compare;

public interface CompareSerivce {
    Compare selectCompareByEdpsCsnAndCarSrn(Long edpsCsn, Long carSrn);
}
