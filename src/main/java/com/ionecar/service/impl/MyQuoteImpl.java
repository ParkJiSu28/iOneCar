package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.MyQuote;
import com.ionecar.service.MyQuoteService;
import com.ionecar.mapper.MyQuoteMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyQuoteImpl implements MyQuoteService {
    private final MyQuoteMapper myQuoteMapper;

    @Override
    public MyQuote selectMyQuoteByEdpsCsn(Long edpsCsn) {
        return myQuoteMapper.selectMyQuoteByEdpsCsn(edpsCsn);
    }
}
