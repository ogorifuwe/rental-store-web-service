package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.InvoiceItem;

import java.util.Iterator;
import java.util.List;

public interface InvoiceItemDao {

    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);
    InvoiceItem findInvoiceItem(int id);
    List<InvoiceItem> findAllInvoiceItem();
    void updateInvoiceItem(InvoiceItem invoiceItem);
    void deleteInvoiceItem(int id);

}
