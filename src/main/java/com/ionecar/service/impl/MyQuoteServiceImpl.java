package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.MyQuote;
import com.ionecar.service.MyQuoteService;
import com.ionecar.mapper.MyQuoteMapper;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyQuoteServiceImpl implements MyQuoteService {
    private final MyQuoteMapper myQuoteMapper;

    @Override
    public List<MyQuote> selectMyQuoteByEdpsCsn(Long edpsCsn) {
        return myQuoteMapper.selectMyQuoteByEdpsCsn(edpsCsn);
    }
}
