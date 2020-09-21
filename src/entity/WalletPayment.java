package entity;

import java.sql.Timestamp;

public class WalletPayment {
    private int idPay;
    private Customer customer;
    private Wallet wallet;
    private Order order;
    private double amountPay;
    private java.sql.Timestamp createdPay;

    public WalletPayment() {

    }

    public WalletPayment(int idPay, Customer customer, Wallet wallet, Order order, double amountPay,
            Timestamp createdPay) {
        this.idPay = idPay;
        this.customer = customer;
        this.wallet = wallet;
        this.order = order;
        this.amountPay = amountPay;
        this.createdPay = createdPay;
    }

    public int getIdPay() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay = idPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(double amountPay) {
        this.amountPay = amountPay;
    }

    public java.sql.Timestamp getCreatedPay() {
        return createdPay;
    }

    public void setCreatedPay(java.sql.Timestamp createdPay) {
        this.createdPay = createdPay;
    }

}
