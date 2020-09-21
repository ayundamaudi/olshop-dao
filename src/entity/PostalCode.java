package entity;

import java.util.List;

public class PostalCode {
    private int postalCode;
    private String city;
    private String province;
    private List<Address> listOfAddress;

    public PostalCode(){

    }

    public PostalCode(int postalCode, String city, String province, List<Address> listOfAddress) {
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.listOfAddress = listOfAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Address> getAddress() {
        return listOfAddress;
    }

    public void setAddress(List<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

}
