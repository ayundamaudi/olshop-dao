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

public class MainAppAddress {
    static CustomerDAO dao2 = new CustomerImpl(MySqlConnection.getConnection());
    static AddressDAO dao = new AddressImpl(MySqlConnection.getConnection());

    public static void main(final String[] args) throws Exception {
        int option = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {
            menu();
            option = Integer.parseInt(input.readLine());
            switch (option) {
                case 1:
                    read(input);
                    break;
                case 2:
                    update(input);
                    break;
                case 3:
                    addAddress(input);
                    break;
                case 4:
                    System.out.println("Thank you...");
                    break;
                default:
                    System.out.println("Enter a value between 1 and 4 !");
                    break;
            }
        } while (option != 4);
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

    private static void addAddress(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println("ADD NEW DATA ADDRES'S CUSTOMER ");
        System.out.println("---------------------");

        System.out.print("Input ID Customer: ");
        int id = (Integer.parseInt(input.readLine()));
        System.out.println();
        Customer customer = dao2.customerFindById(id);
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
        System.out.print("Input new No Tlp: ");
        String tlp = (input.readLine());
        address.setNoTlp(tlp);
        int affectedRow = dao2.addressInsertCustomer(customer);
        System.out.println("==================");
        System.out.println("insert " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void update(BufferedReader input) throws Exception {
        System.out.print("Input ID Customer: ");
        int id = Integer.parseInt(input.readLine());
        System.out.println();
        Customer customer = dao2.customerFindById(id);
        System.out.print("Input ID Address: ");
        int id_addr = Integer.parseInt(input.readLine());
        Address address = dao.addressFindById(id_addr);

        System.out.print("Update Addres: ");
        String address2 = (input.readLine());
        address.setAddress(address2);
        customer.setAddress(address);
        
        System.out.print("Update No Tlp: ");
        String tlp = (input.readLine());
        address.setNoTlp(tlp);
        customer.setAddress(address);
        int affectedRow = dao2.customerUpdateAddress(customer);
        System.out.println("==================");
        System.err.println("delete " + affectedRow + " row");
        System.out.println("==================");
    }

    static void read(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println("  LIST ADDRESS");
        System.out.println("---------------------");

        System.out.print("Input ID Customer: ");
        int id = (Integer.parseInt(input.readLine()));
        System.out.println();

        List<Address> listOfAddressCustomer = dao.addressFindByIdUser(id);
        System.out.println("ID User" + "\t" + "Name Customer" + "\t" + "ID Address" + "\t" + "Address" + "\t" + "No Tlp" + "\t" + "Postal Code" + "\t" + "City" + "\t" + "Province");
        for (Address address : listOfAddressCustomer) {
            System.out.println(address.getCustomer().getIdUser() + "\t" + address.getCustomer().getNameUser() + "\t"
                    + address.getAddress() + "\t" + address.getNoTlp() + "\t" + address.getPostalCode().getPostalCode() + "\t"
                    + address.getPostalCode().getCity() + "\t" + address.getPostalCode().getProvince());
        }
    }

}
