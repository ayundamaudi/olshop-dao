package entity;

import java.util.ArrayList;

public class Brand2 {
    private int idBrand;
    private String brand;
    private ArrayList listOfProduct;

   
    public void addCart(Brand2 cart) {
        this.listOfProduct.add(cart);
    }

    public Brand2() {
        listOfProduct = new ArrayList();
    }
    public Brand2(int idBrand, String brand, ArrayList listOfProduct) {
        this.idBrand = idBrand;
        this.brand = brand;
        this.listOfProduct = listOfProduct;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ArrayList getListOfProduct() {
        return listOfProduct;
    }

    public void setListOfProduct(ArrayList listOfProduct) {
        this.listOfProduct = listOfProduct;
    }
}