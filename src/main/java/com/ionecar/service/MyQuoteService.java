package com.ionecar.service;

import com.ionecar.domain.MyQuote;
import java.util.List;

public interface MyQuoteService {
    List<MyQuote> selectMyQuoteByEdpsCsn(Long edpsCsn);
}
