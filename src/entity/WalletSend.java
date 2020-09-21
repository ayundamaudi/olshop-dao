package entity;

import java.sql.Timestamp;

public class WalletSend {
    private int idWalletSend;
    private Customer toUser;
    private Wallet toWallet;
    private Customer fromUser;
    private Wallet fromWallet;
    private double amountWalletSend;
    private java.sql.Timestamp createdWalletSend;

    public WalletSend() {

    }

    public WalletSend(int idWalletSend, Customer toUser, Wallet toWallet, Customer fromUser, Wallet fromWallet,
            double amountWalletSend, Timestamp createdWalletSend) {
        this.idWalletSend = idWalletSend;
        this.toUser = toUser;
        this.toWallet = toWallet;
        this.fromUser = fromUser;
        this.fromWallet = fromWallet;
        this.amountWalletSend = amountWalletSend;
        this.createdWalletSend = createdWalletSend;
    }

    public int getIdWalletSend() {
        return idWalletSend;
    }

    public void setIdWalletSend(int idWalletSend) {
        this.idWalletSend = idWalletSend;
    }

    public Customer getToUser() {
        return toUser;
    }

    public void setToUser(Customer toUser) {
        this.toUser = toUser;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public Customer getFromUser() {
        return fromUser;
    }

    public void setFromUser(Customer fromUser) {
        this.fromUser = fromUser;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public double getAmountWalletSend() {
        return amountWalletSend;
    }

    public void setAmountWalletSend(double amountWalletSend) {
        this.amountWalletSend = amountWalletSend;
    }

    public java.sql.Timestamp getCreatedWalletSend() {
        return createdWalletSend;
    }

    public void setCreatedWalletSend(java.sql.Timestamp createdWalletSend) {
        this.createdWalletSend = createdWalletSend;
    }

}
