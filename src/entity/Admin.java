package entity;

public class Admin {
    private int idAdmin;
    private String usernameAdmin;
    private String nameAdmin;
    private String passwordAdmin;

    public Admin(){

    }
    
    public Admin(int idAdmin, String usernameAdmin, String nameAdmin, String passwordAdmin) {
        this.idAdmin = idAdmin;
        this.usernameAdmin = usernameAdmin;
        this.nameAdmin = nameAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    // mungkin dipindahin ke class onlinestore
    // public void addProduct(Product product) {
    //     this.listProduct.add(product);
    // }

    // public void updateProduct(Product product) {
    //     
    // }
    
    // public void deleteProduct(Product product) {
    //     
    // }

    // public void viewCustomer(Customer customer) {
    //     
    // }

    // public void processOrder(Order order) {
    //     
    // }
}
