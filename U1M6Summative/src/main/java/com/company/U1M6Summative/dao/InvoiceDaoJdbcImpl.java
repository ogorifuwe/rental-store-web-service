package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcImpl implements InvoiceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_INVOICE_SQL = "select * from invoice where invoice_id=?";
    private static final String SELECT_INVOICE_BY_CUSTOMER_SQL = "select * from invoice where customer_id=?";
    private static final String INSERT_INVOICE_SQL = "insert into invoice(customer_id,order_date,pickup_date,return_date,late_fee) values(?,?,?,?,?)";
    private static final String SELECT_ALL_INVOICE_SQL = "select * from invoice";

    @Autowired
    public InvoiceDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice findInvoiceById(Integer invoiceId) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_INVOICE_SQL,
                    this::mapRowToInvoice,
                    invoiceId);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    public List<Invoice> findAllInvoice() {
        return jdbcTemplate.query(SELECT_ALL_INVOICE_SQL, this::mapRowToInvoice);
    }

    @Override
    public List<Invoice> findInvoicebyCustomerId(Integer customerId) {
        try {
            return jdbcTemplate.query(
                    SELECT_INVOICE_SQL,
                    this::mapRowToInvoice,
                    customerId);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {

        jdbcTemplate.update(
                INSERT_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getOrderDate(),
                invoice.getPickupDate(),
                invoice.getReturnDate(),
                invoice.getLateFee());

        int invoiceId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        invoice.setInvoiceId(invoiceId);

        return invoice;

    }

   private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setOrderDate(rs.getDate("order_date").toLocalDate());
        invoice.setPickupDate(rs.getDate("pickup_date").toLocalDate());
        invoice.setReturnDate(rs.getDate("return_date").toLocalDate());

        return invoice;
    }

}
