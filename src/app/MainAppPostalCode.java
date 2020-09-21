package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.PostalCodeDAO;
import dao.connection.MySqlConnection;
import dao.impl.PostalCodeImpl;
import entity.PostalCode;

public class MainAppPostalCode {
    static PostalCodeDAO dao = new PostalCodeImpl(MySqlConnection.getConnection());

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
                    add(input);
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
        System.out.println("  MENU POSTAL CODE ");
        System.out.println("---------------------");
        System.out.println("[1]View Postal Code");
        System.out.println("[2]Update Postal Code");
        System.out.println("[3]Delete Postal Code");
        System.out.println("[4]Add New Postal Code");
        System.out.println("[5]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    private static void add(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println(" ADD NEW POSTAL CODE ");
        System.out.println("---------------------");

        PostalCode postalCode = new PostalCode();
        System.out.print("Input new postal code: ");
        int code = Integer.parseInt((input.readLine()));
        postalCode.setPostalCode(code);
        System.out.print("Input new city: ");
        String city = (input.readLine());
        postalCode.setCity(city);
        System.out.print("Input new province: ");
        String province = (input.readLine());
        postalCode.setProvince(province);
        int affectedRow = dao.postalCodeInsert(postalCode);
        System.out.println("==================");
        System.out.println("insert " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void delete(BufferedReader input) throws Exception {
        System.out.println("----------------------");
        System.out.println("DELETE NEW POSTAL CODE");
        System.out.println("----------------------");

        System.out.print("Input Postal Code: ");
        int id = (Integer.parseInt(input.readLine()));
        PostalCode postalCode = dao.postalCodeFindById(id);
        int affectedRow = dao.postalCodeUpdate(postalCode);
        affectedRow = dao.postalCodeDelete(id);
        System.out.println("==================");
        System.err.println("delete " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void update(BufferedReader input) throws Exception {
        System.out.print("Input Postal Code: ");
        int id = (Integer.parseInt(input.readLine()));
        System.out.println();
        PostalCode postalCode = dao.postalCodeFindById(id);

        int option = 0;
        do {
            System.out.println("---------------------");
            System.out.println("  UPDATE POSTAL CODE ");
            System.out.println("---------------------");
            System.out.println("[1]City");
            System.out.println("[2]Province");
            System.out.println("[3]Cancel");
            System.out.println("----------------------");
            System.out.print("Input the fields to be changed: ");
            option = Integer.parseInt(input.readLine());
            switch (option) {
                case 1:
                    System.out.print("Update city: ");
                    String city = (input.readLine());
                    postalCode.setCity(city);
                    break;
                case 2:
                    System.out.print("Update province: ");
                    String province = (input.readLine());
                    postalCode.setProvince(province);
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
            int affectedRow = dao.postalCodeUpdate(postalCode);
            System.out.println("==================");
            System.out.println("update " + affectedRow + " row");
            System.out.println("==================");
        }
    }

    static void read() throws Exception {
        System.out.println("---------------------");
        System.out.println("  LIST POSTAL CODE");
        System.out.println("---------------------");

        List<PostalCode> listOfBrand = dao.postalCodeFindAll();
        System.out.println("Postal Code" + "\t" + "City" + "\t\t" + "Province");
        for (PostalCode postalCode : listOfBrand) {
            System.out.println(
                    postalCode.getPostalCode() + "\t\t" + postalCode.getCity() + "\t\t" + postalCode.getProvince());
        }
    }
}
