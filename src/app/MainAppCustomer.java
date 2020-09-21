package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.AddressDAO;
import dao.CustomerDAO;
import dao.connection.MySqlConnection;
import dao.impl.AddressImpl;
import dao.impl.CustomerImpl;
import entity.Address;
import entity.Customer;
import entity.PostalCode;

public class MainAppCustomer {
    static CustomerDAO dao = new CustomerImpl(MySqlConnection.getConnection());
    static AddressDAO dao2 = new AddressImpl(MySqlConnection.getConnection());

    public static void main(final String[] args) throws Exception {
        int option = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {
            menu();
            option = Integer.parseInt(input.readLine());
            switch (option) {
                case 1:
                    read();
                    break;
                case 2:
                    update(input);
                    break;
                case 3:
                    delete(input);
                    break;
                case 4:
                    addProfile(input);
                    break;
                case 5:
                    addAddress(input);
                    break;
                case 6:
                    System.out.println("Thank you...");
                    break;
                default:
                    System.out.println("Enter a value between 1 and 5 !");
                    break;
            }
        } while (option != 6);
    }

    static void menu() {
        System.out.println();
        System.out.println("---------------------");
        System.out.println("  MENU POSTAL CODE ");
        System.out.println("---------------------");
        System.out.println("[1]View Postal Code");
        System.out.println("[2]Update Postal Code");
        System.out.println("[3]Delete Postal Code");
        System.out.println("[4]Add New Data Customer");
        System.out.println("[5]Add New Address Customer");
        System.out.println("[6]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    private static void addProfile(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println("ADD NEW DATA CUSTOMER ");
        System.out.println("---------------------");

        Customer customer = new Customer();

        System.out.print("Input new name: ");
        String name = (input.readLine());
        customer.setNameUser(name);
        System.out.print("Input new email: ");
        String email = (input.readLine());
        customer.setEmailUser(email);
        System.out.print("Input new password: ");
        String password = (input.readLine());
        customer.setPasswordUser(password);
        int affectedRow = dao.customerInsert(customer);
        System.out.println("==================");
        System.out.println("insert " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void addAddress(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println("ADD NEW DATA ADDRES'S CUSTOMER ");
        System.out.println("---------------------");

        System.out.print("Input ID Customer: ");
        int id = (Integer.parseInt(input.readLine()));
        System.out.println();
        Customer customer = dao.customerFindById(id);
        Address address = new Address();
        PostalCode postalCode = new PostalCode();

        System.out.print("Input new address: ");
        String addr = (input.readLine());
        address.setAddress(addr);
        customer.setAddress(address);
        System.out.print("Input new Postal Code: ");
        int code = (Integer.parseInt(input.readLine()));
        postalCode.setPostalCode(code);
        customer.setPostalCode(postalCode);
        int affectedRow = dao.addressInsertCustomer(customer);
        System.out.println("==================");
        System.out.println("insert " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void delete(BufferedReader input) throws Exception {
        System.out.println("----------------------");
        System.out.println("DELETE DATA CUSTOMER   ");
        System.out.println("----------------------");

        System.out.print("Input ID Customer: ");
        int id = (Integer.parseInt(input.readLine()));
        Customer customer = dao.customerFindById(id);
        int affectedRow = dao.customerUpdate(customer);
        affectedRow = dao.customerDelete(id);
        System.out.println("==================");
        System.err.println("delete " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void update(BufferedReader input) throws Exception {
        System.out.print("Input ID Customer: ");
        int id = Integer.parseInt(input.readLine());
        System.out.println();
        Customer customer = dao.customerFindById(id);

        int option = 0;
        do {
            System.out.println("---------------------");
            System.out.println("  UPDATE Customer ");
            System.out.println("---------------------");
            System.out.println("[1]Password");
            System.out.println("[2]Address");
            System.out.println("[3]Cancel");
            System.out.println("----------------------");
            System.out.print("Input the fields to be changed: ");
            option = Integer.parseInt(input.readLine());
            switch (option) {
                case 1:
                    System.out.print("Update Password: ");
                    String password = (input.readLine());
                    customer.setPasswordUser(password);
                    dao.customerUpdatePassword(customer);
                    break;
                case 2:
                    System.out.print("Input ID Address: ");
                    int id_addr = Integer.parseInt(input.readLine());
                    Address address = dao2.addressFindById(id_addr);
                    System.out.print("Update Addres: ");
                    String address2 = (input.readLine());
                    address.setAddress(address2);
                    customer.setAddress(address);
                    dao.customerUpdateAddress(customer);
                    break;
                case 3:
                    System.out.println("Exit the postal code update menu...");
                    break;
                default:
                    System.out.println("Enter a value between 1 and 3 !");
                    break;
            }
        } while (option != 3);

        if ((option >= 1) && (option <= 2)) {
            int affectedRow = dao.customerUpdate(customer);
            System.out.println("==================");
            System.err.println("update " + affectedRow + " row");
            System.out.println("==================");
        }

    }

    static void read() throws Exception {
        System.out.println("---------------------");
        System.out.println("  LIST POSTAL CODE");
        System.out.println("---------------------");

        List<Customer> listOfCustomer = dao.customerFindAll();
        System.out.println("ID User" + "\t" + "Name User" + "\t" + "Email User" + "\t" + "Password User" + "\t" + "No Tlp" + "\t" + "Address" + "\t" + "Postal Code" + "\t" + "City" + "\t" + "Province");
        for (Customer customer : listOfCustomer) {
            System.out.println(customer.getIdUser() + "\t" + customer.getNameUser() + "\t" + customer.getEmailUser()
                    + "\t" + customer.getPasswordUser() + "\t" + customer.getAddress().getNoTlp() + "\t"
                    + customer.getAddress().getAddress() + "\t" + customer.getPostalCode().getPostalCode() + "\t"
                    + customer.getPostalCode().getCity() + "\t" + customer.getPostalCode().getProvince());
        }
    }
}
