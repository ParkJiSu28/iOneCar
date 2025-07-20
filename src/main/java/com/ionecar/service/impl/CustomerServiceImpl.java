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

    // 고객 로그인 시 해당 고객 존재 여부 확인
    @Override
    public boolean loginByEdpsCsn(long edpsCsn) {
        Customer customer = customerMapper.findCustomerByEdpsCsn(edpsCsn);
        return customer != null; // edps_csn 존재 시 true
    }
    // 고객로그인 시 고객 견적 받은 이력 있는지 확인
    @Override
    public boolean qntYnCheckByEdpsCsn(long edpsCsn) {
        Customer customer = customerMapper.findCustomerByEdpsCsn(edpsCsn);
        return customer.getQntYn().equals("Y"); // qnt_yn 값이 Y인 경우 true
    }   
    // 고객 삭제
    @Override
    public void deleteCustomerByEdpsCsn(long edpsCsn) {
        customerMapper.deleteCustomerByEdpsCsn(edpsCsn);
    }
    // 고객 견적 받은 이력 있는지 확인
    @Override
    public void updateQntYn(long edpsCsn, String qntYn) {
        customerMapper.updateQntYn(edpsCsn, qntYn);
    }
    

}