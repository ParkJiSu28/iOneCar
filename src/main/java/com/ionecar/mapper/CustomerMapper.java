package com.ionecar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.ionecar.domain.Customer;

@Mapper
public interface CustomerMapper {
  
    Customer findCustomerByEdpsCsn(long edpsCsn);
    void deleteCustomerByEdpsCsn(long edpsCsn);
    void updateQntYn(long edpsCsn, String qntYn);
}


