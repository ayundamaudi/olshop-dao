package entity;

import java.sql.Timestamp;

public class Customer {
    private int idUser;
    private String emailUser;
    private String passwordUser;
    private String nameUser;
    private java.sql.Timestamp createdUser;
    private Address address;
    private PostalCode postalCode;

    public Customer() {

    }

    public Customer(int idUser, String emailUser, String passwordUser, String nameUser, 
            Timestamp createdUser, Address address, PostalCode postalCode) {
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.nameUser = nameUser;
        this.createdUser = createdUser;
        this.address = address;
        this.postalCode = postalCode;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public java.sql.Timestamp getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(java.sql.Timestamp createdUser) {
        this.createdUser = createdUser;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    
}
