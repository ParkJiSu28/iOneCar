package com.ionecar.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.ionecar.domain.Option;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;


@Mapper
public interface OptionTableMapper {

    void insertOption(Option option);
    List<Option> selectOptionsByCarSrn(@Param("carSrn") long carSrn);
    
} 