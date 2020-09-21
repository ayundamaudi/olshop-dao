package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import entity.Admin;
import entity.Brand;
import entity.Customer;
import entity.Order;
import entity.OrderMethod;
import entity.Product;

public class OrderImpl implements OrderDAO{
    private Connection conn;
	
	public OrderImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int orderInsert(Order order) throws Exception {
		String sql = "insert into tb_order(shipping_fee, subtotal, status, id_admin, id_user, id_method, id_address) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, order.getShippingFee());
        pst.setDouble(2, order.getSubtotal());
        pst.setString(3, order.getStatus());
        pst.setInt(4, order.getAdmin().getIdAdmin());
        pst.setInt(5, order.getCustomer().getIdUser());
		pst.setInt(6, order.getOrderMethod().getIdMethod());
		pst.setInt(7, order.getAddress().getIdAddress());
		int affectedRow = pst.executeUpdate();
		System.out.println(pst);
		return affectedRow;
	}

	@Override
	public int orderInsertCustomer(Order order) throws Exception {
		String sql = "insert into tb_order(id_user) values(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, order.getCustomer().getIdUser());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int orderUpdate(Order order) throws Exception {
		String sql = "update tb_order set shipping_fee=?, subtotal=?, status=?, created_order=?, created_proses=?, id_admin=?, id_user=?, id_method=? where id_order=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, order.getShippingFee());
        pst.setDouble(2, order.getSubtotal());
        pst.setString(3, order.getStatus());
        pst.setTimestamp(4, order.getCreatedOrder());
        pst.setTimestamp(5, order.getCreatedProses());
        pst.setInt(6, order.getAdmin().getIdAdmin());
        pst.setInt(7, order.getCustomer().getIdUser());
        pst.setInt(8, order.getOrderMethod().getIdMethod());
        pst.setInt(9, order.getIdOrder());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int orderDelete(int idOrder) throws Exception{
		String sql = "delete from tb_order where id_order=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idOrder);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Order orderFindByIdOrder(int idOrder) throws Exception{
		Order order = null;
		String sql = "select id_order, shipping_fee, subtotal, status, created_order, created_proses, id_admin, id_user, id_method from tb_order where id_order=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idOrder);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			order = new Order();
			Admin admin = new Admin();
			Customer customer = new Customer();
			OrderMethod orderMethod = new OrderMethod();

			order.setIdOrder(rs.getInt("id_order"));
			order.setShippingFee(rs.getDouble("shipping_fee"));
			order.setSubtotal(rs.getDouble("subtotal"));
            order.setStatus(rs.getString("status"));
            order.setCreatedOrder(rs.getTimestamp("created_order"));
			order.setCreatedProses(rs.getTimestamp("created_proses"));

			admin.setIdAdmin(rs.getInt("id_admin"));
			order.setAdmin(admin);

			customer.setIdUser(rs.getInt("id_user"));
			order.setCustomer(customer);

			orderMethod.setIdMethod(rs.getInt("id_method"));
			order.setOrderMethod(orderMethod);
		}
		return order;
	}


	@Override
	public Order orderFindByIdUser(int idUser) throws Exception {
		return null;

	}

	@Override
	public List<Order> orderFindAll() throws Exception {
		List<Order> listOfOrder = new ArrayList<Order>();
		String sql = "select id, shipping_fee, subtotal, status, created_order, created_proses, id_admin, id_user, id_method from tb_order";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Order order = new Order();
			Admin admin = new Admin();
			Customer customer = new Customer();
			OrderMethod orderMethod = new OrderMethod();

			order.setIdOrder(rs.getInt("id_order"));
			order.setShippingFee(rs.getDouble("shipping_fee"));
			order.setSubtotal(rs.getDouble("subtotal"));
            order.setStatus(rs.getString("status"));
            order.setCreatedOrder(rs.getTimestamp("created_order"));
			order.setCreatedProses(rs.getTimestamp("created_proses"));

			admin.setIdAdmin(rs.getInt("id_admin"));
			order.setAdmin(admin);

			customer.setIdUser(rs.getInt("id_user"));
			order.setCustomer(customer);

			orderMethod.setIdMethod(rs.getInt("id_method"));
			order.setOrderMethod(orderMethod);
			listOfOrder.add(order);
		}
		return listOfOrder;
	}

	@Override
	public List<Product> ProductFindAll() throws Exception {
		List<Product> listOfProduct = new ArrayList<Product>();
		String sql = "select p.id_product, p.type, p.photo, p.descrip, p.color, p.price, p.stock, p.sold, p.created_product, b.brand from tb_product p JOIN tb_brand b on (p.id_brand = b.id_brand) order by id_product";
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
			
			brand.setBrand(rs.getString("brand"));

			product.setBrand(brand);

			listOfProduct.add(product);
		}
		return listOfProduct;
	}
}
