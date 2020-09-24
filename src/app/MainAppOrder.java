package app;

import dao.BrandDAO;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.connection.MySqlConnection;
import dao.impl.BrandImpl;
import dao.impl.CustomerImpl;
import dao.impl.OrderDetailImpl;
import dao.impl.OrderImpl;
import dao.impl.ProductImpl;
import entity.Address;
import entity.Admin;
import entity.Brand;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import entity.OrderMethod;
import entity.Product;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                case 3:
                System.out.println("Thank you...");
                break;
                default:
                System.out.println("Enter a value between 1 and 5 !");
                break;
            }
        } while (option != 3);
    }

    private static void listProduct() throws Exception {
        System.out.println("---------------------");
        System.out.println("    LIST PRODUCT ");
        System.out.println("---------------------");

        List<Product> listOfProduct = dao.ProductFindAll();
        System.out.println(
        "ID Product" +
        "\t" +
        "Name Brand" +
        "\t" +
        "Type" +
        "\t" +
        "Description" +
        "\t" +
        "Color" +
        "\t" +
        "Price" +
        "\t" +
        "Stock"
        );
        for (Product product : listOfProduct) {
            System.out.println(
                product.getIdProduct() +
                "\t" +
                product.getBrand().getBrand() +
                "\t" +
                product.getType() +
                "\t" +
                product.getDescrip() +
                "\t" +
                product.getColor() +
                "\t" +
                product.getPrice() +
                "\t" +
                product.getStock()
            );
        }
    }

    static void menu() {
        System.out.println();
        System.out.println("---------------------");
        System.out.println("    MENU BRAND ");
        System.out.println("---------------------");
        System.out.println("[1]View Product");
        System.out.println("[2]Add Order");
        System.out.println("[3]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    private static void add(BufferedReader input) throws Exception {
        Customer customer = new Customer();
        Order order = new Order();
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

        List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
        System.out.println("=========Add Cart==============");

        Double totalPriceForm = 0.0, finalPriceForm = 0.0;

        Scanner scan = new Scanner(System.in);
        String keep = "y";
        do {
        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();
        Brand brand = new Brand();
        BrandDAO dao5 = new BrandImpl(MySqlConnection.getConnection());
        System.out.print("Input ID Product: ");
        int idProduct = (Integer.parseInt(input.readLine()));
        product = dao3.ProductFindById(idProduct);
        product.getPrice();
        int a = product.getBrand().getIdBrand();
        brand = dao5.brandFindById(a);
        product.setBrand(brand);
        orderDetail.setProduct(product);

        System.out.println("nama = " + brand.getBrand());
        System.out.println("harga = " + product.getPrice());

        System.out.print("Input Qty Product: ");
        int qty = (Integer.parseInt(input.readLine()));
        orderDetail.setQtyProduct(qty);

        totalPriceForm +=
            orderDetail.getProduct().getPrice() * orderDetail.getQtyProduct();
        System.out.print("Continue shopping (y/n)? ");
        keep = scan.nextLine();

        listOrderDetail.add(orderDetail);
        } while (keep.equalsIgnoreCase("y"));

        System.out.println(
        "No" +
        "\t" +
        "ID Product" +
        "\t" +
        "Name Brand" +
        "\t" +
        "Type" +
        "\t" +
        "Color" +
        "\t" +
        "Price"
        );

        for (int x = 0; x < listOrderDetail.size(); x++) {
        System.out.println(
            (x + 1) +
            "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getProduct().getIdProduct() +
            "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getProduct().getBrand().getBrand() +
            "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getProduct().getType() +
            "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getProduct().getColor() +
            "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getProduct().getPrice() +
            "\t" +
            ((OrderDetail) listOrderDetail.get(x)).getQtyProduct());
        }

        System.out.print("Input ID Address: ");
        int idAddr = (Integer.parseInt(input.readLine()));
        address.setIdAddress(idAddr);
        order.setAddress(address);

        double fee = 9000;
        order.setShippingFee(fee);
        finalPriceForm = totalPriceForm + fee;
        System.out.println("Total Price : " + finalPriceForm);

        order.setSubtotal(finalPriceForm);

        String status = "Process";
        order.setStatus(status);

        int idMethod = 1;
        orderMethod.setIdMethod(idMethod);
        order.setOrderMethod(orderMethod);

        int idAdmin = 1;
        admin.setIdAdmin(idAdmin);
        order.setAdmin(admin);

        dao.orderInsert(order);
        for (int i = 0; i < listOrderDetail.size(); i++) {
        dao4.orderDetailInsert((OrderDetail) listOrderDetail.get(i));
        }
    }
}
