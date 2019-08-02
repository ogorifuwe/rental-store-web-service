package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoJdbcImpl implements CustomerDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id=?";
    private static final String SELECT_CUSTOMER_BY_PHONE = "select * from customer where phone=?";
    private static final String SELECT_CUSTOMER_BY_EMAIL = "select * from customer where email =?";
    private static final String SELECT_ALLCUSTOMER = "select * from customer";
    private static final String INSERT_CUSTOMER = "insert into customer(first_name,last_name,email,company,phone) values(?,?,?,?,?)";
    private static final String UPDATE_CUSTOMER = "update customer set first_name=?,last_name=?,email=?,company=?,phone=? where " +
            "customer_id=?";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id=?";


    @Override
    public Customer findCustomerById(int id) {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
        try {
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_BY_ID, this::mapRowToCustomer, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
=======
//        jdbcTemplate.queryForObject()
        return null;
>>>>>>> Stashed changes
=======
        //jdbcTemplate.queryForObject();
        return null;
>>>>>>> Stashed changes
    }

    @Override
    public Customer findCustomerByPhone(String phone) {
        return jdbcTemplate.queryForObject(SELECT_CUSTOMER_BY_PHONE,this::mapRowToCustomer,phone);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return jdbcTemplate.queryForObject(SELECT_CUSTOMER_BY_EMAIL,this::mapRowToCustomer,email);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return jdbcTemplate.query(SELECT_ALLCUSTOMER,this::mapRowToCustomer);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        jdbcTemplate.update(INSERT_CUSTOMER,customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getCompany(),
                customer.getPhone());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",Integer.class);
        customer.setCustomerId(id);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {

        jdbcTemplate.update(UPDATE_CUSTOMER,customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getCompany(),
                customer.getPhone(),customer.getCustomerId());
    }

    @Override
    public void deleteCustomer(int id)  {

        jdbcTemplate.update(DELETE_CUSTOMER,id);
    }

    private Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException{

        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setCompany(rs.getString("company"));
        customer.setEmail(rs.getString("email"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setPhone(rs.getString("phone"));

        return customer;
    }
}
