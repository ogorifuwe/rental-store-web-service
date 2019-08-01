package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoJdbcImpl implements CustomerDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id=?";
    private static final String SELECT_CUSTOMER_BY

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }

    @Override
    public Customer findCustomerByPhone(String phone) {
        return null;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }
}
