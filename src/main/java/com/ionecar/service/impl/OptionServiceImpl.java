package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Option;
import com.ionecar.service.OptionService;
import com.ionecar.mapper.OptionTableMapper;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService  {

    private final OptionTableMapper optionTableMapper;

    @Override
    public void insertOption(Option option){
        optionTableMapper.insertOption(option);
    }
    
    @Override
    public List<Option> selectOptionsByCarSrn(long carSrn){
        return optionTableMapper.selectOptionsByCarSrn(carSrn);
    }

}
