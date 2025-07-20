package com.ionecar.service;

public interface CustomerService {
    boolean loginByEdpsCsn(long edpsCsn);
    boolean qntYnCheckByEdpsCsn(long edpsCsn);
    void deleteCustomerByEdpsCsn(long edpsCsn);
    void updateQntYn(long edpsCsn, String qntYn);
}