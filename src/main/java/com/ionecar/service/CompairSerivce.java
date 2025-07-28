package com.ionecar.service;

import com.ionecar.domain.Compair;

public interface CompairSerivce {
    Compair selectCompairByEdpsCsnAndCarSrn(Long edpsCsn, Long carSrn);
}
