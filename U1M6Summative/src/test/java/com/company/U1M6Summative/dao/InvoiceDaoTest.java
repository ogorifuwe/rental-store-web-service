package com.company.U1M6Summative.dao;


import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;
    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Customer> cList = customerDao.findAllCustomer();
        for (Customer c : cList) {
            customerDao.deleteCustomer(c.getCustomerId());
        }

//        List<Invoice> iList = invoiceDao.getAllInvoice();

//        for (Invoice i : iList) {
//            invoiceDao.deleteInvoice(i.getInvoiceId());
//        }


        }
//    private Integer invoiceId;
//    private Integer customerId;
//    private LocalDate orderDate;
//    private LocalDate pickupDate;
//    private LocalDate returnDate;
//    private BigDecimal lateFee;


    @Test
    public void addFindInvoice() {

        // Need to create a Customer first
        Customer customer = new Customer();
        customer.setFirstName("Miller");
        customer.setLastName("John");
        customer.setEmail("a.b@c.com");
        customer.setCompany("www.aandb.com");
        customer.setPhone("111-222-3456");
        customer = customerDao.addCustomer(customer);

        
        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2010, 1, 5));
        invoice.setPickupDate(LocalDate.of(2010, 1, 6));
        invoice.setReturnDate(LocalDate.of(2010, 1, 7));
        invoice.setLateFee(new BigDecimal("2.95"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.findInvoiceById(invoice.getInvoiceId());

        assertEquals(invoice1, invoice);

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2010, 1, 5));
        invoice.setPickupDate(LocalDate.of(2010, 1, 6));
        invoice.setReturnDate(LocalDate.of(2010, 1, 7));
        invoice.setLateFee(new BigDecimal("2.95"));

        invoice = invoiceDao.addInvoice(invoice);

    }

    @Test
    public void findAllInvoice() {

        // Need to create a Customer first
        // Need to create a Customer first
        Customer customer = new Customer();
        customer.setFirstName("Miller");
        customer.setLastName("John");
        customer.setEmail("a.b@c.com");
        customer.setCompany("www.aandb.com");
        customer.setPhone("111-222-3456");
        customer = customerDao.addCustomer(customer);


        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2010, 1, 5));
        invoice.setPickupDate(LocalDate.of(2010, 1, 6));
        invoice.setReturnDate(LocalDate.of(2010, 1, 7));
        invoice.setLateFee(new BigDecimal("2.95"));

        invoice = invoiceDao.addInvoice(invoice);


        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(customer.getCustomerId());
        invoice1.setOrderDate(LocalDate.of(2010, 1, 5));
        invoice1.setPickupDate(LocalDate.of(2010, 1, 6));
        invoice1.setReturnDate(LocalDate.of(2010, 1, 7));
        invoice1.setLateFee(new BigDecimal("2.95"));

        invoice1 = invoiceDao.addInvoice(invoice);


        List<Invoice> aList = invoiceDao.findAllInvoice();

        assertEquals(aList.size(), 2);

    }
}
