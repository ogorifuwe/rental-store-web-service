package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerJdbcTest {

    @Autowired
    CustomerDao customerDao;

    @Before
    public void setUp(){

        List<Customer> customerList = customerDao.findAllCustomer();
        customerList.stream().forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));
    }

    @After
    public void tearDown(){

    }

    @Test
    public void addGetDeleteCustomerTest(){

        Customer customer = new Customer();
        customer.setPhone("111-111-1111");
        customer.setLastName("LastNameOne");
        customer.setFirstName("FirstNameOne");
        customer.setEmail("emailOne@gmail.com");
        customer.setCompany("companyOne");
        customerDao.addCustomer(customer);

       Customer customer1 = customerDao.findCustomerById(customer.getCustomerId());
       assertEquals(customer,customer1);

       customerDao.deleteCustomer(customer.getCustomerId());
       customer1 = customerDao.findCustomerById(customer.getCustomerId());

       assertNull(customer1);

    }

    @Test
    public void getAllCustomersTest(){

        Customer customer1 = new Customer();
        customer1.setPhone("111-111-1111");
        customer1.setLastName("LastNameOne");
        customer1.setFirstName("FirstNameOne");
        customer1.setEmail("emailOne@gmail.com");
        customer1.setCompany("companyOne");
        customerDao.addCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setPhone("222-222-2222");
        customer2.setLastName("LastNameTwo");
        customer2.setFirstName("FirstNameTwo");
        customer2.setEmail("emailTwo@gmail.com");
        customer2.setCompany("companyTwo");
        customerDao.addCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setPhone("333-333-3333");
        customer3.setLastName("LastNameThree");
        customer3.setFirstName("FirstNameTHree");
        customer3.setEmail("emailThree@gmail.com");
        customer3.setCompany("companyThree");
        customerDao.addCustomer(customer3);

        List<Customer> customerList = customerDao.findAllCustomer();

        assertEquals(3,customerList.size());
    }

    @Test
    public void findCustomerByPhoneTest(){

        Customer customer1 = new Customer();
        customer1.setPhone("111-111-1111");
        customer1.setLastName("LastNameOne");
        customer1.setFirstName("FirstNameOne");
        customer1.setEmail("emailOne@gmail.com");
        customer1.setCompany("companyOne");
        customerDao.addCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setPhone("222-222-2222");
        customer2.setLastName("LastNameTwo");
        customer2.setFirstName("FirstNameTwo");
        customer2.setEmail("emailTwo@gmail.com");
        customer2.setCompany("companyTwo");
        customerDao.addCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setPhone("333-333-3333");
        customer3.setLastName("LastNameThree");
        customer3.setFirstName("FirstNameThree");
        customer3.setEmail("emailThree@gmail.com");
        customer3.setCompany("companyThree");
        customerDao.addCustomer(customer3);

        Customer customer4 = customerDao.findCustomerByPhone("222-222-2222");

        assertEquals(customer2,customer4);
    }

    @Test
    public void findCustomerByEmailTest(){

        Customer customer1 = new Customer();
        customer1.setPhone("111-111-1111");
        customer1.setLastName("LastNameOne");
        customer1.setFirstName("FirstNameOne");
        customer1.setEmail("emailOne@gmail.com");
        customer1.setCompany("companyOne");
        customerDao.addCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setPhone("222-222-2222");
        customer2.setLastName("LastNameTwo");
        customer2.setFirstName("FirstNameTwo");
        customer2.setEmail("emailTwo");
        customer2.setCompany("companyTwo@gmail.com");
        customerDao.addCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setPhone("333-333-3333");
        customer3.setLastName("LastNameThree");
        customer3.setFirstName("FirstNameThree");
        customer3.setEmail("emailThree@gmail.com");
        customer3.setCompany("companyThree");
        customerDao.addCustomer(customer3);

        Customer customer4 = customerDao.findCustomerByEmail("emailThree@gmail.com");

        assertEquals(customer3,customer4);
    }

    @Test
    public void updateCustomerTest(){

        Customer customer1 = new Customer();
        customer1.setPhone("111-111-1111");
        customer1.setLastName("LastNameOne");
        customer1.setFirstName("FirstNameOne");
        customer1.setEmail("emailOne@gmail.com");
        customer1.setCompany("companyOne");
        customerDao.addCustomer(customer1);

        customer1.setCompany("updated company");
        customerDao.updateCustomer(customer1);

        Customer customer2 = customerDao.findCustomerById(customer1.getCustomerId());

        assertEquals(customer1,customer2);
    }
}
