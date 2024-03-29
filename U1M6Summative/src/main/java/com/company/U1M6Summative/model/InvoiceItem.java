package com.company.U1M6Summative.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class InvoiceItem {

    private Integer invoiceItemId;
    private Integer invoiceId;
    private Integer itemId;
    private Integer quantity;
    private BigDecimal unitRate;
    private BigDecimal discount;

    MathContext mathContext = new MathContext(2);

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitRate() {
        return unitRate.round(mathContext);
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate.round(mathContext);
    }

    public BigDecimal getDiscount() {
        return discount.round(mathContext);
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount.round(mathContext);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceItem)) return false;
        InvoiceItem that = (InvoiceItem) o;
        return invoiceItemId == that.invoiceItemId &&
                invoiceId == that.invoiceId &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                Objects.equals(unitRate, that.unitRate) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, invoiceId, itemId, quantity, unitRate, discount);
    }
}
