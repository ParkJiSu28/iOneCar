package com.ionecar.service;
import com.ionecar.domain.Customer;

public interface CustomerService {
    boolean findCustomerByEdpsCsn(long edpsCsn);
    Customer getCustomerByEdpsCsn(long edpsCsn);
    boolean qntYnCheckByEdpsCsn(long edpsCsn);
    void deleteCustomerByEdpsCsn(long edpsCsn);
    void updateQntYn(long edpsCsn, String qntYn);
    void updateQntYnByCarSrn(long carSrn, String qntYn);
    void cleanupNullDataAndUpdateQntYn(long edpsCsn);
}