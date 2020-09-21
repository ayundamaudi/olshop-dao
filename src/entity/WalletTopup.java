package entity;

import java.sql.Timestamp;

public class WalletTopup {
    private int idTopup;
    private Customer customer;
    private Wallet wallet;
    private String noAccountTopup;
    private double amountTopup;
    private java.sql.Timestamp createdTopup;

    public WalletTopup() {

    }

    public WalletTopup(int idTopup, Customer customer, Wallet wallet, String noAccountTopup, double amountTopup,
            Timestamp createdTopup) {
        this.idTopup = idTopup;
        this.customer = customer;
        this.wallet = wallet;
        this.noAccountTopup = noAccountTopup;
        this.amountTopup = amountTopup;
        this.createdTopup = createdTopup;
    }

    public int getIdTopup() {
        return idTopup;
    }

    public void setIdTopup(int idTopup) {
        this.idTopup = idTopup;
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

    public String getNoAccountTopup() {
        return noAccountTopup;
    }

    public void setNoAccountTopup(String noAccountTopup) {
        this.noAccountTopup = noAccountTopup;
    }

    public double getAmountTopup() {
        return amountTopup;
    }

    public void setAmountTopup(double amountTopup) {
        this.amountTopup = amountTopup;
    }

    public java.sql.Timestamp getCreatedTopup() {
        return createdTopup;
    }

    public void setCreatedTopup(java.sql.Timestamp createdTopup) {
        this.createdTopup = createdTopup;
    }

}
