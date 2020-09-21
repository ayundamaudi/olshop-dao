package entity;

public class Wallet {
    private String idWallet;
    private Customer customer;
    private double currentBalance;
    
    public Wallet(){

    }

    public Wallet(String idWallet, Customer customer, double currentBalance) {
        this.idWallet = idWallet;
        this.customer = customer;
        this.currentBalance = currentBalance;
    }

    public String getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(String idWallet) {
        this.idWallet = idWallet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

}
