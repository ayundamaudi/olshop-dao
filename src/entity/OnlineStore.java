package entity;

import java.util.ArrayList;

public class OnlineStore {
    private ArrayList listProduct;
    private ArrayList listCart;
    
    public OnlineStore() {
        listProduct = new ArrayList();
        listCart = new ArrayList();
        // listProduct.add(new Product(1, 1, 1, "IphoneX", 
        // "iphoneX.jpg", "iOS 13", "Black", 7000000, 20, 5, "2020-09-14")); 
    }

    public ArrayList getListProduct() {
        return listProduct;
    }

    public ArrayList getListCart() {
        return listCart;
    }

    public void addProduct(Product product) {
        this.listProduct.add(product);
    }

    public int deleteProduct(int idProduct) {
        if (searchProduct(idProduct) != null) {
            this.listProduct.remove(searchProduct(idProduct));
            return 1;
        } else
            return 0;
    }

    public Product searchProduct(int idProduct) {
        Product product = null;
        for (int x = 0; x < listProduct.size(); x++) {
            product = (Product) listProduct.get(x);
            product = null;
        }
        return product;
    }

    public void addCart(Cart cart) {
        this.listCart.add(cart);
    }

    public int deleteCart(String namaBrand) {
        if (searchCart(namaBrand) != null) {
            this.listCart.remove(searchCart(namaBrand));
            return 1;
        } else
            return 0;
    }

    public Cart searchCart(String namaBrand) {
        Cart cart = null;
        for (int x = 0; x < listCart.size(); x++) {
            cart = (Cart) listCart.get(x);
            if (cart.getProduct().equalsIgnoreCase(namaBrand))
                break;
            cart = null;
        }
        return cart;
    }

    // public String pinjamBuku(int nomor, int idProduct) {
    //     if (searchProduct(idProduct) != null) {
    //             Product product = searchProduct(idProduct);
    //             deleteProduct(idProduct);
    //             return "Transaksi berhasil...";
    //     } else {
    //         return "Product Keluar....";
    //     }
    // }

    // public void deleteCart(int nomor, int idProduct) {
    //     addProduct(searchProduct(idProduct));
    // }

}
