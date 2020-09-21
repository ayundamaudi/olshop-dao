package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.BrandDAO;
import dao.connection.MySqlConnection;
import dao.impl.BrandImpl;
import entity.Brand;
import entity.Brand2;

public class MainAppBrand {
    static BrandDAO dao = new BrandImpl(MySqlConnection.getConnection());
    static Brand brand = new Brand();
    static Brand2 brand2 = new Brand2();

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
        System.out.println("    MENU BRAND ");
        System.out.println("---------------------");
        System.out.println("[1]View Brand");
        System.out.println("[2]Update Brand");
        System.out.println("[3]Delete Brand");
        System.out.println("[4]Add New Brand");
        System.out.println("[5]Exit");
        System.out.println("----------------------");
        System.out.print("Select a Menu Option : ");
    }

    private static void add(BufferedReader input) throws Exception {
        System.out.println("---------------------");
        System.out.println("   ADD NEW BRAND ");
        System.out.println("---------------------");

        Brand brand = new Brand();
        System.out.print("Input new name brand: ");
        String name = (input.readLine());
        brand.setBrand(name);
        int affectedRow = dao.brandInsert(brand);
        System.out.println("==================");
        System.out.println("insert " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void delete(BufferedReader input) throws Exception {
        System.out.print("Input ID Brand : ");
        int id = (Integer.parseInt(input.readLine()));
        Brand brand = dao.brandFindById(id);
        int affectedRow = dao.brandUpdate(brand);
        affectedRow = dao.brandDelete(id);
        System.out.println("==================");
        System.err.println("delete " + affectedRow + " row");
        System.out.println("==================");
    }

    private static void update(BufferedReader input) throws Exception {
        System.out.print("Input ID Brand to be changed: ");
        int id = (Integer.parseInt(input.readLine()));
        System.out.println();
        Brand brand = dao.brandFindById(id);
        System.out.print("Update Name Brand: ");
        String name = (input.readLine());
        brand.setBrand(name);
        int affectedRow = dao.brandUpdate(brand);
        System.out.println("==================");
        System.out.println("update " + affectedRow + " row");
        System.out.println("==================");
    }

    static void read() throws Exception {
        List<Brand> listOfBrand = dao.brandFindAll();
        System.out.println("ID Brand" + "\t" + "Name Brand");
        for (Brand brand : listOfBrand) {
            System.out.println(brand.getIdBrand() + "\t\t" + brand.getBrand());
        }
    }
}
