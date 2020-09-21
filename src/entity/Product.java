package entity;

import java.sql.Timestamp;

public class Product {
    private int idProduct;
    private Brand brand;
    private Admin admin;
    private String type;
    private String photo;
    private String descrip;
    private String color;
    private double price;
    private int stock;
    private int sold;
    private java.sql.Timestamp createdProduct;

    public Product() {
    }

    public Product(int idProduct, Brand brand, Admin admin, String type, String photo, String descrip, String color,
            double price, int stock, int sold, Timestamp createdProduct) {
        this.idProduct = idProduct;
        this.brand = brand;
        this.admin = admin;
        this.type = type;
        this.photo = photo;
        this.descrip = descrip;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
        this.createdProduct = createdProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public java.sql.Timestamp getCreatedProduct() {
        return createdProduct;
    }

    public void setCreatedProduct(java.sql.Timestamp createdProduct) {
        this.createdProduct = createdProduct;
    }
}