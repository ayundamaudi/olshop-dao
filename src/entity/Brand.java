package entity;

import java.util.List;

public class Brand {
    private int idBrand;
    private String brand;
    private List<Product> listOfProduct;

    public Brand(){

    }

    public Brand(int idBrand, String brand, List<Product> listOfProduct) {
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

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    public void setListOfProduct(List<Product> listOfProduct) {
        this.listOfProduct = listOfProduct;
    }
    

}