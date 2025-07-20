package com.ionecar.service.impl;

import org.springframework.stereotype.Service;
import com.ionecar.domain.Customer;
import com.ionecar.service.CustomerService;
import com.ionecar.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    @Override
    public boolean loginByEdpsCsn(String edpsCsn) {
        Customer customer = customerMapper.findCustomerByEdpsCsn(edpsCsn);
        return customer != null; // edps_csn 존재 시 true
    }
}