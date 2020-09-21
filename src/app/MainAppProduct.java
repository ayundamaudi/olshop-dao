package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.ProductDAO;
import dao.connection.MySqlConnection;
import dao.impl.ProductImpl;
import entity.Admin;
import entity.Brand;
import entity.Product;

public class MainAppProduct {
	static ProductDAO dao = new ProductImpl(MySqlConnection.getConnection());

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
					best();
					break;
				case 6:
					recent();
					break;
				case 7:
					search(input);
					break;
				case 8:
					System.out.println("Thank you...");
					break;
				default:
					System.out.println("Enter a value between 1 and 7 !");
					break;
			}
		} while (option != 8);
	}

	private static void search(BufferedReader input) throws Exception {
		System.out.println("---------------------");
		System.out.println("   SEARCH PRODUCT ");
		System.out.println("---------------------");

		System.out.print("Input ID Product: ");
		String param = (input.readLine());
		List<Product> listOfProduct = dao.ProductFindBySearch(param);
		System.out.println("ID Product"+"|"+"Type"+"|"+"Photo"+"|"+"Description"+"|"+"Color"+"|"+"Price"+"|"+"Stock"+"|"+"Sold"+"|"+"Date Created Product"+"|"+"ID Brand");
		for (Product product : listOfProduct) {
			System.out.println(product.getIdProduct() + " " + product.getType() + "|" + product.getPhoto() + "|"
					+ product.getDescrip() + "|" + product.getColor() + "|" + product.getPrice() + "|"
					+ product.getStock() + "|" + product.getSold() + "|" + product.getCreatedProduct() + "|"
					+ product.getBrand().getIdBrand());		}
	}

	private static void recent() throws Exception {
		System.out.println("---------------------");
		System.out.println("    NEW PRODUCT ");
		System.out.println("---------------------");

		List<Product> listOfProduct = dao.ProductNewMonth();
		System.out.println("ID Product"+"|"+"Type"+"|"+"Photo"+"|"+"Description"+"|"+"Color"+"|"+"Price"+"|"+"Stock"+"|"+"Sold"+"|"+"Date Created Product"+"|"+"ID Brand");
		for (Product product : listOfProduct) {
			System.out.println(product.getIdProduct() + " " + product.getType() + "|" + product.getPhoto() + "|"
					+ product.getDescrip() + "|" + product.getColor() + "|" + product.getPrice() + "|"
					+ product.getStock() + "|" + product.getSold() + "|" + product.getCreatedProduct() + "|"
					+ product.getBrand().getIdBrand());
		}
	}

	private static void best() throws Exception {
		System.out.println("---------------------");
		System.out.println(" BEST SELLER PRODUCT ");
		System.out.println("---------------------");

		List<Product> listOfProduct = dao.ProductBestSeller();
		System.out.println("ID Product"+"|"+"Type"+"|"+"Photo"+"|"+"Description"+"|"+"Color"+"|"+"Price"+"|"+"Stock"+"|"+"Sold"+"|"+"Date Created Product"+"|"+"ID Brand");
		for (Product product : listOfProduct) {
			System.out.println(product.getIdProduct() + " " + product.getType() + "|" + product.getPhoto() + "|"
					+ product.getDescrip() + "|" + product.getColor() + "|" + product.getPrice() + "|"
					+ product.getStock() + "|" + product.getSold() + "|" + product.getCreatedProduct() + "|"
					+ product.getBrand().getIdBrand());
		}
	}

	static void menu() {
		System.out.println();
		System.out.println("---------------------");
		System.out.println("    MENU PRODUCT ");
		System.out.println("---------------------");
		System.out.println("[1]View Product");
		System.out.println("[2]Update Product");
		System.out.println("[3]Delete Product");
		System.out.println("[4]Add New Product");
		System.out.println("[5]View Best Seller Product");
		System.out.println("[6]View New Product");
		System.out.println("[7]Search View");
		System.out.println("[8]Exit");
		System.out.println("----------------------");
		System.out.print("Select a Menu Option : ");
	}

	private static void add(BufferedReader input) throws Exception {
		System.out.println("---------------------");
		System.out.println("   ADD NEW PRODUCT ");
		System.out.println("---------------------");

		Product product = new Product();
		Brand brand = new Brand();
		Admin admin = new Admin();
		System.out.print("Input new type: ");
		String type = (input.readLine());
		product.setType(type);
		System.out.print("Input new photo: ");
		String photo = (input.readLine());
		product.setPhoto(photo);
		System.out.print("Input new description: ");
		String descrip = (input.readLine());
		product.setDescrip(descrip);
		System.out.print("Input new color: ");
		String color = (input.readLine());
		product.setColor(color);
		System.out.print("Input new price: ");
		double price = (Integer.parseInt(input.readLine()));
		product.setPrice(price);
		System.out.print("Input new stock: ");
		int stock = (Integer.parseInt(input.readLine()));
		product.setStock(stock);
		System.out.print("Input new sold: ");
		int sold = (Integer.parseInt(input.readLine()));
		product.setSold(sold);
		System.out.print("Input new ID brand: ");
		int idBrand = (Integer.parseInt(input.readLine()));
		brand.setIdBrand(idBrand);
		product.setBrand(brand);
		int idAdmin = 1;
		admin.setIdAdmin(idAdmin);
		product.setAdmin(admin);
		int affectedRow = dao.ProductInsert(product);
		System.out.println("==================");
		System.out.println("insert " + affectedRow + " row");
		System.out.println("==================");
	}

	private static void delete(BufferedReader input) throws Exception {
		System.out.println("---------------------");
		System.out.println("    DELETE PRODUCT ");
		System.out.println("---------------------");

		System.out.print("Input ID Product: ");
		int id = (Integer.parseInt(input.readLine()));
		Product product = dao.ProductFindById(id);
		int affectedRow = dao.ProductUpdate(product);
		affectedRow = dao.ProductDelete(id);
		System.err.println("delete " + affectedRow + " row");
	}

	private static void update(BufferedReader input) throws Exception {
		System.out.print("Input ID Product: ");
		int id = (Integer.parseInt(input.readLine()));
		System.out.println();
		Product product = dao.ProductFindById(id);
		Brand brand = new Brand();

		int option = 0;
		do {
			System.out.println("---------------------");
			System.out.println("    UPDATE PRODUCT ");
			System.out.println("---------------------");
			System.out.println("[1]Type");
			System.out.println("[2]Photo");
			System.out.println("[3]Description");
			System.out.println("[4]Color");
			System.out.println("[5]Price");
			System.out.println("[6]Stock");
			System.out.println("[7]Sold");
			System.out.println("[8]ID Brand");
			System.out.println("[9]Cancel");
			System.out.println("----------------------");
			System.out.print("Input the fields to be changed: ");
			option = Integer.parseInt(input.readLine());
			switch (option) {
				case 1:
					System.out.print("Update Type: ");
					String type = (input.readLine());
					product.setType(type);
					break;
				case 2:
					System.out.print("Update photo: ");
					String photo = (input.readLine());
					product.setPhoto(photo);
					break;
				case 3:
					System.out.print("Update description: ");
					String descrip = (input.readLine());
					product.setDescrip(descrip);
					break;
				case 4:
					System.out.print("Update color: ");
					String color = (input.readLine());
					product.setColor(color);
					break;
				case 5:
					System.out.print("Update price: ");
					double price = (Integer.parseInt(input.readLine()));
					product.setPrice(price);
					break;
				case 6:
					System.out.print("Update stock: ");
					int stock = (Integer.parseInt(input.readLine()));
					product.setStock(stock);
					break;
				case 7:
					System.out.print("Update sold: ");
					int sold = (Integer.parseInt(input.readLine()));
					product.setSold(sold);
					break;
				case 8:
					System.out.print("Update ID brand: ");
					int idBrand = (Integer.parseInt(input.readLine()));
					brand.setIdBrand(idBrand);
					product.setBrand(brand);
					break;
				case 9:
					System.out.println("Exit the product update menu...");
					break;
				default:
					System.out.println("Enter a value between 1 and 9 !");
					break;
			}
		} while (option != 9);

		if ((option >= 1) && (option <= 8)) {
			int affectedRow = dao.ProductUpdate(product);
			System.out.println("==================");
			System.out.println("update " + affectedRow + " row");
			System.out.println("==================");	
		}
	}

	static void read() throws Exception {
		System.out.println("---------------------");
		System.out.println("    LIST PRODUCT ");
		System.out.println("---------------------");

		List<Product> listOfProduct = dao.ProductFindAll();
		System.out.println("ID Product"+"|"+"Type"+"|"+"Photo"+"|"+"Description"+"|"+"Color"+"|"+"Price"+"|"+"Stock"+"|"+"Sold"+"|"+"Date Created Product"+"|"+"ID Brand");
		for (Product product : listOfProduct) {
			System.out.println(product.getIdProduct() + " " + product.getType() + "|" + product.getPhoto() + "|"
					+ product.getDescrip() + "|" + product.getColor() + "|" + product.getPrice() + "|"
					+ product.getStock() + "|" + product.getSold() + "|" + product.getCreatedProduct() + "|"
					+ product.getBrand().getIdBrand());
		}
	}
}