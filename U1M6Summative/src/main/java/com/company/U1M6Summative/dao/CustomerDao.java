package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findCustomerById(int id);
    Customer findCustomerByPhone(String phone);
    Customer findCustomerByEmail(String email);
    List<Customer> findAllCustomer();
    Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);


}
