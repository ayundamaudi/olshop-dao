package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import entity.Brand;
import entity.Product;

public class ProductImpl implements ProductDAO{
    private Connection conn;
	
	public ProductImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int ProductInsert(Product product) throws Exception {
		String sql = "insert into tb_product(type, photo, descrip, color, price, stock, sold, id_brand, id_admin) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, product.getType());
        pst.setString(2, product.getPhoto());
        pst.setString(3, product.getDescrip());
        pst.setString(4, product.getColor());
        pst.setDouble(5, product.getPrice());
        pst.setInt(6, product.getStock());
        pst.setInt(7, product.getSold());
        // pst.setTimestamp(8, product.getCreatedProduct());
		pst.setInt(8, product.getBrand().getIdBrand());
		pst.setInt(9, product.getAdmin().getIdAdmin());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int ProductUpdate(Product product) throws Exception {
		String sql = "update tb_product set type=?, photo=?, descrip=?, color=?, price=?, stock=?, sold=?, id_brand=? where id_product=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, product.getType());
        pst.setString(2, product.getPhoto());
        pst.setString(3, product.getDescrip());
        pst.setString(4, product.getColor());
        pst.setDouble(5, product.getPrice());
        pst.setInt(6, product.getStock());
        pst.setInt(7, product.getSold());
        pst.setInt(8, product.getBrand().getIdBrand());
        pst.setInt(9, product.getIdProduct());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int ProductDelete(int idProduct) throws Exception{
		String sql = "delete from tb_product where id_product=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idProduct);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Product ProductFindById(int idProduct) throws Exception{
		Product product = null;
		Brand brand = null;
		String sql = "select p.id_product, p.type, p.photo, p.descrip, p.color, p.price, p.stock, p.sold, p.created_product, b.id_brand from tb_product p INNER JOIN tb_brand b on (p.id_brand = b.id_brand) where id_product=? order by id_product";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idProduct);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			product = new Product();
			brand = new Brand();

			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPhoto(rs.getString("photo"));
            product.setDescrip(rs.getString("descrip"));
            product.setColor(rs.getString("color"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
            product.setSold(rs.getInt("sold"));
            product.setCreatedProduct(rs.getTimestamp("created_product"));
			
			brand.setIdBrand(rs.getInt("id_brand"));

			product.setBrand(brand);
		}
		return product;
	}

	@Override
	public List<Product> ProductFindByIdProduct(int idProduct) throws Exception {
		List<Product> listOfByIdProduct = new ArrayList<Product>();
		String sql = "select p.id_product, p.type, p.photo, p.descrip, p.color, p.price, p.stock, p.sold, p.created_product, b.id_brand from tb_product p INNER JOIN tb_brand b on (p.id_brand = b.id_brand) where id_product=? order by id_product";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, idProduct);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Product product = new Product();
			Brand brand = new Brand();

			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPhoto(rs.getString("photo"));
            product.setDescrip(rs.getString("descrip"));
            product.setColor(rs.getString("color"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
            product.setSold(rs.getInt("sold"));
            product.setCreatedProduct(rs.getTimestamp("created_product"));
			
			brand.setIdBrand(rs.getInt("id_brand"));

			product.setBrand(brand);
			listOfByIdProduct.add(product);
		}
		return listOfByIdProduct;
	}

	@Override
	public List<Product> ProductFindBySearch(String param) throws Exception {
		List<Product> listOfProduct = new ArrayList<Product>();
		String sql = "select p.id_product, p.type, p.photo, p.descrip, p.color, p.price, p.stock, p.sold, p.created_product, b.id_brand from tb_product p INNER JOIN tb_brand b on (p.id_brand = b.id_brand) WHERE p.color LIKE CONCAT ( '%',?, '%') OR p.type LIKE CONCAT ( '%',?, '%') OR p.descrip LIKE CONCAT ( '%',?, '%') OR b.brand LIKE CONCAT ( '%',?, '%') ;";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setString(1, param);
		pst.setString(2, param);
		pst.setString(3, param);
		pst.setString(4, param);
		ResultSet rs = pst.executeQuery();
		
		Product product = new Product();
		Brand brand = new Brand();

		while(rs.next()) {
			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPhoto(rs.getString("photo"));
            product.setDescrip(rs.getString("descrip"));
            product.setColor(rs.getString("color"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
            product.setSold(rs.getInt("sold"));
			product.setCreatedProduct(rs.getTimestamp("created_product"));
			
			brand.setIdBrand(rs.getInt("id_brand"));

			product.setBrand(brand);
			
			listOfProduct.add(product);
		}
		return listOfProduct;
	}

	@Override
	public List<Product> ProductBestSeller() throws Exception{
		List<Product> listOfProduct = new ArrayList<Product>();
		String sql = "select p.id_product, p.type, p.photo, p.descrip, p.color, p.price, p.stock, p.sold, p.created_product, b.id_brand from tb_product p INNER JOIN tb_brand b on (p.id_brand = b.id_brand) order by p.sold desc limit 3";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			Brand brand = new Brand();

			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPhoto(rs.getString("photo"));
            product.setDescrip(rs.getString("descrip"));
            product.setColor(rs.getString("color"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
            product.setSold(rs.getInt("sold"));
            product.setCreatedProduct(rs.getTimestamp("created_product"));
			
			brand.setIdBrand(rs.getInt("id_brand"));

			product.setBrand(brand);

			listOfProduct.add(product);
		}
		return listOfProduct;
	}

	@Override
	public List<Product> ProductNewMonth() throws Exception{
		List<Product> listOfProduct = new ArrayList<Product>();
		String sql = "SELECT * FROM tb_product  WHERE MONTH(created_product) = MONTH(NOW()) ORDER BY created_product";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			Brand brand = new Brand();

			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPhoto(rs.getString("photo"));
            product.setDescrip(rs.getString("descrip"));
            product.setColor(rs.getString("color"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
            product.setSold(rs.getInt("sold"));
            product.setCreatedProduct(rs.getTimestamp("created_product"));
			
			brand.setIdBrand(rs.getInt("id_brand"));

			product.setBrand(brand);

			listOfProduct.add(product);
		}
		return listOfProduct;

	}

	@Override
	public List<Product> ProductFindAll() throws Exception {
		List<Product> listOfProduct = new ArrayList<Product>();
		String sql = "select p.id_product, p.type, p.photo, p.descrip, p.color, p.price, p.stock, p.sold, p.created_product, b.id_brand from tb_product p INNER JOIN tb_brand b on (p.id_brand = b.id_brand) order by id_product";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			Brand brand = new Brand();

			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPhoto(rs.getString("photo"));
            product.setDescrip(rs.getString("descrip"));
            product.setColor(rs.getString("color"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
            product.setSold(rs.getInt("sold"));
            product.setCreatedProduct(rs.getTimestamp("created_product"));
			
			brand.setIdBrand(rs.getInt("id_brand"));

			product.setBrand(brand);

			listOfProduct.add(product);
		}
		return listOfProduct;
	}
}
