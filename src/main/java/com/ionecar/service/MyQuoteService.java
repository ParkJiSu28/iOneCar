package com.ionecar.service;

import com.ionecar.domain.MyQuote;

public interface MyQuoteService {
    MyQuote selectMyQuoteByEdpsCsn(Long edpsCsn);
}
