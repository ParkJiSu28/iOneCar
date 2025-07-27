package com.ionecar.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.ionecar.domain.MyQuote;

@Mapper
public interface MyQuoteMapper {
    MyQuote selectMyQuoteByEdpsCsn(@Param("edpsCsn") Long edpsCsn);
}

