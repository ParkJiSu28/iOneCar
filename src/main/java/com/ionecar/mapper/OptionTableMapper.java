package com.ionecar.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.ionecar.domain.Option;
import java.util.Map;

@Mapper
public interface OptionTableMapper {

    void insertOption(Option option);
    
} 