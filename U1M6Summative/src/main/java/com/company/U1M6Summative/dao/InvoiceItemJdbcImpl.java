package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemJdbcImpl implements InvoiceItemDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public static final String INSERT_INVOICE_ITEM ="insert into invoice_item(invoice_id,item_id,quantity,unit_rate_discount)" +
            " values(?,?,?,?,?,?)";
    public static final String SELECT_INVOICE_ITEM_BY_ID = "select * from invoice_item where invoice_item_id=?";
    public static final String SELECTALL_INVOICE_ITEM = "select * from invoice_item";
    public static final String UPDATE_INVOICE_ITEM = "update invoice_item set quantity=? where invoice_item_id=?";
    public static final String DELETE_INVOICE_ITEM = "delete from invoice_item where invoice_item_id=?";

    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {

        jdbcTemplate.update(INSERT_INVOICE_ITEM,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemId(),
                invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(),
                invoiceItem.getDiscount());
        int id = jdbcTemplate.queryForObject("select LAST_INSERTED_ID()",Integer.class);
        invoiceItem.setInvoiceItemId(id);
        return invoiceItem;
    }

    @Override
    public InvoiceItem findInvoiceItem(int id) {

       return jdbcTemplate.queryForObject(SELECT_INVOICE_ITEM_BY_ID,this::mapRowToInvoiceItem,id);
    }

    @Override
    public List<InvoiceItem> findAllInvoiceItem() {
        return jdbcTemplate.query(SELECTALL_INVOICE_ITEM,this::mapRowToInvoiceItem);
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {
         jdbcTemplate.update(UPDATE_INVOICE_ITEM,invoiceItem.getQuantity(),invoiceItem.getInvoiceItemId());
    }

    @Override
    public void deleteInvoiceItem(int id) {

        jdbcTemplate.update(DELETE_INVOICE_ITEM,id);
    }

    private InvoiceItem mapRowToInvoiceItem(ResultSet rs, int rowNum) throws SQLException {

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceItemId(rs.getInt("invoice_item_id"));
        invoiceItem.setItemId(rs.getInt("item_id"));
        invoiceItem.setInvoiceId(rs.getInt("invoice_id"));
        invoiceItem.setDiscount(rs.getBigDecimal("discount"));
        invoiceItem.setUnitRate(rs.getBigDecimal("unit_rate"));
        invoiceItem.setQuantity(rs.getInt("quantity"));

        return invoiceItem;
    }
}
