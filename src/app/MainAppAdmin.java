package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.AdminDAO;
import dao.connection.MySqlConnection;
import dao.impl.AdminImpl;
import entity.Admin;

public class MainAppAdmin {
    static AdminDAO dao = new AdminImpl(MySqlConnection.getConnection());

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
        System.out.println("   MENU DATA ADMIN");
        System.out.println("---------------------");
        System.out.println("[1]View Data Admin");
        System.out.println("[2]Update Data Admin");
        System.out.println("[3]Delete Data Admin");
        System.out.println("[4]Add New Data Admin");
        System.out.println("[5]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    private static void add(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println(" ADD NEW DATA ADMIN ");
        System.out.println("---------------------");

        Admin admin = new Admin();
        System.out.print("Input new username: ");
        String code = (input.readLine());
        admin.setUsernameAdmin(code);
        System.out.print("Input new name: ");
        String city = (input.readLine());
        admin.setNameAdmin(city);
        System.out.print("Input password: ");
        String province = (input.readLine());
        admin.setPasswordAdmin(province);
        int affectedRow = dao.adminInsert(admin);
        System.out.println("==================");
        System.out.println("insert " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void delete(BufferedReader input) throws Exception {
        System.out.println("----------------------");
        System.out.println("DELETE NEW DATA ADMIN");
        System.out.println("----------------------");

        System.out.print("Input ID Admin: ");
        int id = (Integer.parseInt(input.readLine()));
        Admin admin = dao.adminFindById(id);
        int affectedRow = dao.adminUpdate(admin);
        affectedRow = dao.adminDelete(id);
        System.out.println("==================");
        System.err.println("delete " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void update(BufferedReader input) throws Exception {
        System.out.print("Input ID Admin: ");
        int id = (Integer.parseInt(input.readLine()));
        System.out.println();
        Admin admin = dao.adminFindById(id);

        int option = 0;
        do {
            System.out.println("---------------------");
            System.out.println("  UPDATE DATA ADMIN ");
            System.out.println("---------------------");
            System.out.println("[1]Username");
            System.out.println("[2]Name");
            System.out.println("[3]Password");
            System.out.println("[4]Cancel");
            System.out.println("----------------------");
            System.out.print("Input the fields to be changed: ");
            option = Integer.parseInt(input.readLine());
            switch (option) {
                case 1:
                    System.out.print("Update username: ");
                    String username = (input.readLine());
                    admin.setUsernameAdmin(username);
                    break;
                case 2:
                    System.out.print("Update name: ");
                    String name = (input.readLine());
                    admin.setNameAdmin(name);
                    break;
                case 3:
                    System.out.print("Update password: ");
                    String password = (input.readLine());
                    admin.setPasswordAdmin(password);
                    break;
                case 4:
                    System.out.println("Exit the admin update menu...");
                    break;
                default:
                    System.out.println("Enter a value between 1 and 4 !");
                    break;
            }
        } while (option != 4);

        if ((option >= 1) && (option <= 3)) {
            int affectedRow = dao.adminUpdate(admin);
            System.out.println("==================");
            System.out.println("update " + affectedRow + " row");
            System.out.println("==================");
        }
    }

    static void read() throws Exception {
        System.out.println("---------------------");
        System.out.println("  LIST DATA ADMIN");
        System.out.println("---------------------");

        List<Admin> listOfBrand = dao.adminFindAll();
        System.out.println("ID Admin"+"\t"+"Username Admin" + "\t\t" + "Name Admin" + "\t\t" + "Password Admin");
        for (Admin admin : listOfBrand) {
            System.out.println(admin.getIdAdmin() + "\t\t" + admin.getUsernameAdmin() + "\t\t" + admin.getNameAdmin()+"\t\t"+admin.getPasswordAdmin());
        }
    }
}
