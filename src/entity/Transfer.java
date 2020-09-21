package entity;

import java.sql.Timestamp;

public class Transfer {
    private int idTransfer;
    private Order order;
    private Customer customer;
    private String noAccount;
    private double amountTransfer;
    private java.sql.Timestamp createdTransfer;

    public Transfer() {

    }

    public Transfer(int idTransfer, Order order, Customer customer, String noAccount, double amountTransfer,
            Timestamp createdTransfer) {
        this.idTransfer = idTransfer;
        this.order = order;
        this.customer = customer;
        this.noAccount = noAccount;
        this.amountTransfer = amountTransfer;
        this.createdTransfer = createdTransfer;
    }

    public int getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(int idTransfer) {
        this.idTransfer = idTransfer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNoAccount() {
        return noAccount;
    }

    public void setNoAccount(String noAccount) {
        this.noAccount = noAccount;
    }

    public double getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(double amountTransfer) {
        this.amountTransfer = amountTransfer;
    }

    public java.sql.Timestamp getCreatedTransfer() {
        return createdTransfer;
    }

    public void setCreatedTransfer(java.sql.Timestamp createdTransfer) {
        this.createdTransfer = createdTransfer;
    }

}
