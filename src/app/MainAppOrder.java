package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.connection.MySqlConnection;
import dao.impl.CustomerImpl;
import dao.impl.OrderDetailImpl;
import dao.impl.OrderImpl;
import dao.impl.ProductImpl;
import entity.Address;
import entity.Admin;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import entity.OrderMethod;
import entity.Product;

public class MainAppOrder {
    static OrderDAO dao = new OrderImpl(MySqlConnection.getConnection());
    static CustomerDAO dao2 = new CustomerImpl(MySqlConnection.getConnection());
    static ProductDAO dao3 = new ProductImpl(MySqlConnection.getConnection());
    static OrderDetailDAO dao4 = new OrderDetailImpl(MySqlConnection.getConnection());

    public static void main(final String[] args) throws Exception {
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
                    add(input);
                    break;
                // case 3:
                // delete(input);
                // break;
                // case 4:
                // add(input);
                // break;
                case 5:
                    System.out.println("Thank you...");
                    break;
                default:
                    System.out.println("Enter a value between 1 and 5 !");
                    break;
            }
        } while (option != 5);
    }

    private static void listProduct() throws Exception {
        System.out.println("---------------------");
        System.out.println("    LIST PRODUCT ");
        System.out.println("---------------------");

        List<Product> listOfProduct = dao.ProductFindAll();
        System.out.println("ID Product" + "\t" + "Name Brand" + "\t" + "Type" + "\t" + "Description" + "\t" + "Color"
                + "\t" + "Price" + "\t" + "Stock");
        for (Product product : listOfProduct) {
            System.out.println(product.getIdProduct() + "\t" + product.getBrand().getBrand() + "\t" + product.getType()
                    + "\t" + product.getDescrip() + "\t" + product.getColor() + "\t" + product.getPrice() + "\t"
                    + product.getStock());
        }
    }

    static void menu() {
        System.out.println();
        System.out.println("---------------------");
        System.out.println("    MENU BRAND ");
        System.out.println("---------------------");
        System.out.println("[1]View Product");
        System.out.println("[2]Add Order");
        System.out.println("[3]Delete Brand");
        System.out.println("[4]Add New Brand");
        System.out.println("[5]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    private static void add(BufferedReader input) throws Exception {

        Customer customer = new Customer();
        Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();
        Admin admin = new Admin();
        OrderMethod orderMethod = new OrderMethod();
        Address address = new Address();

        System.out.println("---------------------");
        System.out.println("  ADD ORDER ");
        System.out.println("---------------------");
        System.out.print("Input ID Customer: ");
        int id = Integer.parseInt(input.readLine());
        customer.setIdUser(id);
        order.setCustomer(customer);
        dao2.customerFindById(id);

        List<OrderDetail> listOrderDetail = new ArrayList();
        // int option = 0;
        // do {

        // System.out.println("---------------------");
        // System.out.println(" MENU ADD ORDER ");
        // System.out.println("---------------------");
        System.out.println("=========Add Cart==============");
        // System.out.println("[2]List Cart");
        // System.out.println("[3]Cancel");
        // System.out.println("----------------------");
        // System.out.print("Input action: ");
        // option = Integer.parseInt(input.readLine());
        // switch (option) {
        // case 1:
        Double totalPriceForm = 0.0, finalPriceForm = 0.0;

        Scanner scan = new Scanner(System.in);
        String keep = "y";
        do {
            System.out.print("Input ID Product: ");
            int idProduct = (Integer.parseInt(input.readLine()));
            Product product2 = dao3.ProductFindById(idProduct);
            orderDetail.setProduct(product2);

            System.out.print("Input Qty Product: ");
            int qty = (Integer.parseInt(input.readLine()));
            orderDetail.setQtyProduct(qty);

            // double subTotal = ;
            // order.setSubtotal(subTotal);

            String status = "Process";
            order.setStatus(status);

            int idMethod = 1;
            orderMethod.setIdMethod(idMethod);
            order.setOrderMethod(orderMethod);

            int idAdmin = 1;
            admin.setIdAdmin(idAdmin);
            order.setAdmin(admin);
            listOrderDetail.add(orderDetail);

            

            System.out.print("Continue shopping (y/n)? ");
            keep = scan.nextLine();
        } while (keep.equalsIgnoreCase("y"));

        System.out.print("Input ID Address: ");
        int idAddr = (Integer.parseInt(input.readLine()));
        address.setIdAddress(idAddr);
        order.setAddress(address);

        

        

        for (int x = 0; x < listOrderDetail.size(); x++) {

            totalPriceForm += ((OrderDetail) listOrderDetail.get(x)).getProduct().getPrice()
                    * ((OrderDetail) listOrderDetail.get(x)).getQtyProduct();

                    System.out.println("============================");
            System.out.println("ini price " + listOrderDetail.get(x).getProduct().getPrice());
            System.out.println("ini qty " + listOrderDetail.get(x).getQtyProduct());

            System.out.println("============================");
            System.out.println((x + 1) + "\t" + ((OrderDetail) listOrderDetail.get(x)).getProduct().getIdProduct() + "t"+ ((OrderDetail) listOrderDetail.get(x)).getProduct().getPrice() + "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getQtyProduct());
        }

        double fee = 9000;
        order.setShippingFee(fee);
        finalPriceForm = totalPriceForm + fee;
        System.out.println("Total Price : " + finalPriceForm);

        // try {
        order.setSubtotal(finalPriceForm);

        dao.orderInsert(order);
        for (int i = 0; i < listOrderDetail.size(); i++) {
            dao4.orderDetailInsert((OrderDetail) listOrderDetail.get(i));
        }

        // orderDetail.getOrder().getSubtotal();

        // for (int i = 0; i < address; i++) {
        // for int
        // }

        // break;
        // case 2:
        // List<OrderDetail> listCart = dao4.orderDetailById();
        // // System.out.println("ID User" + "\t" + "Name Customer" + "\t" + "ID
        // Address" +
        // // "\t" + "Address" + "\t" + "No Tlp" + "\t" + "Postal Code" + "\t" + "City"
        // +
        // // "\t" + "Province");
        // for (OrderDetail orderDetail2 : listCart) {
        // System.out.println(orderDetail2.getOrder().getIdOrder() + "\t"
        // + orderDetail2.getProduct().getIdProduct() + "\t"
        // + orderDetail2.getProduct().getBrand().getIdBrand() + "\t"
        // + orderDetail2.getProduct().getType() + "\t" +
        // orderDetail2.getProduct().getPrice()
        // + "\t" + orderDetail2.getQtyProduct() + "\t" +
        // orderDetail2.getOrder().getSubtotal());
        // }

        // break;
        // case 3:
        // System.out.println("Exit the postal code update menu...");
        // break;
        // default:
        // System.out.println("Enter a value between 1 and 3 !");
        // break;
        // }
        // } while (option != 3);

    }

    // private static void delete(BufferedReader input) throws Exception {
    // System.out.print("Input ID Brand : ");
    // int id = (Integer.parseInt(input.readLine()));
    // Brand brand = dao.brandFindById(id);
    // int affectedRow = dao.brandUpdate(brand);
    // affectedRow = dao.brandDelete(id);
    // System.out.println("==================");
    // System.err.println("delete " + affectedRow + " row");
    // System.out.println("==================");
    // }

    // private static void update(BufferedReader input) throws Exception {
    // System.out.print("Input ID Brand to be changed: ");
    // int id = (Integer.parseInt(input.readLine()));
    // System.out.println();
    // Brand brand = dao.brandFindById(id);
    // System.out.print("Update Name Brand: ");
    // String name = (input.readLine());
    // brand.setBrand(name);
    // int affectedRow = dao.brandUpdate(brand);
    // System.out.println("==================");
    // System.out.println("update " + affectedRow + " row");
    // System.out.println("==================");
    // }

    // static void read() throws Exception {
    // List<Brand> listOfBrand = dao.brandFindAll();
    // System.out.println("ID Brand" + "\t" + "Name Brand");
    // for (Brand brand : listOfBrand) {
    // System.out.println(brand.getIdBrand() + "\t\t" + brand.getBrand());
    // }
    // }

}
