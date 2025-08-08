package com.ionecar.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.ionecar.domain.MyQuote;
import java.util.List;

@Mapper
public interface MyQuoteMapper {
    List<MyQuote> selectMyQuoteByEdpsCsn(@Param("edpsCsn") Long edpsCsn);
}

