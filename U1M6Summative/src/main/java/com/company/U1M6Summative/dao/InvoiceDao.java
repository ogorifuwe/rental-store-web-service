package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;

import java.util.List;


public interface InvoiceDao {

    Invoice findInvoiceById (Integer id);
    List<Invoice> findAllInvoice();
    List<Invoice> findInvoicebyCustomerId (Integer id);
    Invoice addInvoice (Invoice invoice);





}
