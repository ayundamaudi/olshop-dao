package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import customer.Cart;
import customer.OnlineStore;
import customer.Product;

public class TestOnlineStore {
    static OnlineStore olshop = new OnlineStore();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int option = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {
            menu();
            option = Integer.parseInt(input.readLine());
            switch (option) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    listCart();
                    break;
                case 3:
                    toCart(input);
                    break;
                case 4:
                    deleteCart(input);
                    break;
                case 5:
                    System.out.println("Thank you...");
                    break;
                default:
                    System.out.println("Enter a value between 1 and 5 !");
                    break;
            }
        } while (option != 5);
    }

    static void menu() {
        System.out.println();
        System.out.println("---------------------");
        System.out.println("    ONLINE STORE");
        System.out.println("---------------------");
        System.out.println("[1]List Product");
        System.out.println("[2]View Cart");
        System.out.println("[3]Add Product To Cart");
        System.out.println("[4]Delete Product In Cart");
        System.out.println("[5]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    static void listProduct() {
        System.out.println(
                "------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLIST PRODUCT");
        System.out.println(
                "------------------------------------------------------------------------------------------");
        System.out.println("ID Product" + "\t"  + "ID Admin" + "\t"  + "ID Brand" + "\t\t" + "Type" + "\t\t" + 
        "Photo" + "\t"  +"Description" + "\t" + "Color" + "\t\t" + "Price" + "Stock" + "\t"  + "Sold" + "\t" +
        "Date");

        for (int x = 0; x < olshop.getListProduct().size(); x++) {
            System.out.println(((Product) olshop.getListProduct().get(x)).getIdProduct() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getIdAdmin() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getIdBrand() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getType() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getPhoto() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getDescrip() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getColor() + "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getPrice()+ "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getSotck()+ "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getSold()+ "\t\t"
                    + ((Product) olshop.getListProduct().get(x)).getCreatedProduct()
                    );
        }
        System.out.println(
                "------------------------------------------------------------------------------------------");
    }

    static void listCart() {
        System.out.println(
                "------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLIST CART");
        System.out.println(
                "------------------------------------------------------------------------------------------");
        System.out.println("Name Brand" + "\t"  + "Type" + "\t"  + "Color" + "\t\t" + "Quantity");

        for (int x = 0; x < olshop.getListCart().size(); x++) {
            System.out.println(((Cart) olshop.getListCart().get(x)).getNamaBrand() + "\t\t"
                    + ((Cart) olshop.getListCart().get(x)).getType() + "\t\t"
                    + ((Cart) olshop.getListCart().get(x)).getColor() + "\t\t"
                    + ((Cart) olshop.getListCart().get(x)).getQuantity()
                    );
        }
        System.out.println(
                "------------------------------------------------------------------------------------------");
    }

    static void toCart(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("ADD PRODUCT TO CART");
        System.out.println("--------------------------------------");
        Cart cart = new Cart();
        System.out.print("Name Brand: ");
        cart.setNamaBrand(input.readLine());
        System.out.print("Type: ");
        cart.setType(input.readLine());
        System.out.print("Color: ");
        cart.setColor(input.readLine());
        System.out.print("Quantity: ");
        cart.setQuantity(Integer.parseInt(input.readLine()));
        olshop.addCart(cart);
        System.out.println("Success...");
    }

    static void deleteCart(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("CLEAR BUKU");
        System.out.println("--------------------------------------");
        System.out.print("Input Name Brand: ");
        String namaBrand = input.readLine();
        int x = olshop.deleteCart(namaBrand);
        System.out.println(x);
        if (x == 1)
            System.out.println("Success...");
        else
            System.out.println("Failed...");
    }
}