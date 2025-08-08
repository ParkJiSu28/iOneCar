package com.ionecar.service;
import com.ionecar.domain.Option;
import java.util.List;

public interface OptionService {

    void insertOption(Option option);
    List<Option> selectOptionsByCarSrn(long carSrn);
}
