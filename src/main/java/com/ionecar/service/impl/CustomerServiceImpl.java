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
    public boolean findCustomerByEdpsCsn(long edpsCsn) {
        Customer customer = customerMapper.findCustomerByEdpsCsn(edpsCsn);
        System.out.println("customer = " + customer); // 로그로 확인
        return customer != null;
    }
    @Override
    public Customer getCustomerByEdpsCsn(long edpsCsn) {
        return customerMapper.findCustomerByEdpsCsn(edpsCsn);
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
    
    // carSrn으로 고객의 qnt_yn 업데이트
    @Override
    public void updateQntYnByCarSrn(long carSrn, String qntYn) {
        customerMapper.updateQntYnByCarSrn(carSrn, qntYn);
    }

    // NULL 값 정리 및 qnt_yn 업데이트
    @Override
    public void cleanupNullDataAndUpdateQntYn(long edpsCsn) {
        // 1. NULL 값이 있는 Car 삭제
        customerMapper.deleteNullCars(edpsCsn);
        
        // 2. 삭제된 Car와 연결된 Option 삭제
        customerMapper.deleteOrphanedOptions();
        
        // 3. 삭제된 Car와 연결된 Purchase 삭제
        customerMapper.deleteOrphanedPurchases();
        
        // 4. 완전한 데이터가 있는지 확인하여 qnt_yn 업데이트
        customerMapper.updateQntYnBasedOnCompleteData(edpsCsn);
    }

}