package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDetailDAO;
import entity.Brand;
import entity.Order;
import entity.OrderDetail;
import entity.Product;

public class OrderDetailImpl implements OrderDetailDAO{
    private Connection conn;
	
	public OrderDetailImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int orderDetailInsert(OrderDetail orderDetail) throws Exception {

		String sql = "insert into tb_order_detail(id_product, qty_product, id_order) values(?,?,(select max(id_order) from tb_order))";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, orderDetail.getProduct().getIdProduct());
        pst.setInt(2, orderDetail.getQtyProduct());
		int affectedRow = pst.executeUpdate();
		System.out.println(pst);
		return affectedRow;		
	}

	@Override
	public int orderDetailUpdate(OrderDetail orderDetail) throws Exception {
		String sql = "update tb_order_detail set id_product=?, qty_product where id_order=?";
		PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, orderDetail.getProduct().getIdProduct());
        pst.setInt(2, orderDetail.getQtyProduct());
        pst.setInt(3, orderDetail.getOrder().getIdOrder());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int orderDetailDelete(int idOrder) throws Exception{
		String sql = "delete from tb_order_detail where id_order=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idOrder);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public OrderDetail orderDetailFindById(int idOrder) throws Exception{
		OrderDetail orderDetail = null;
		String sql = "select id_order, id_product, qty_product from tb_order_detail where id_order=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idOrder);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			orderDetail = new OrderDetail();
			Order order = new Order();
			Product product = new Product();

			order.setIdOrder(rs.getInt("id_order"));
			orderDetail.setOrder(order);			

			product.setIdProduct(rs.getInt("id_product"));
			orderDetail.setProduct(product);

            orderDetail.setQtyProduct(rs.getInt("qty_product"));
		}
		return orderDetail;
	}

	@Override
	public List<OrderDetail> orderDetailById() throws Exception {
		List<OrderDetail> listCart = new ArrayList<OrderDetail>();
		String sql = "select od.id_order, od.id_product, b.brand, p.type, p.price, od.qty_product, SUM(p.price*od.qty_product) subtotal from tb_order_detail od INNER JOIN tb_product p ON od.id_product = p.id_product INNER JOIN tb_brand b ON p.id_brand = b.id_brand where id_order=(select max(id_order) from tb_order)";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		Product product = new Product();
		Brand brand = new Brand();
		Order order = new Order();
		while(rs.next()) {
			OrderDetail orderDetail = new OrderDetail();
			order.setIdOrder(rs.getInt("id_order"));
			orderDetail.setOrder(order);
			orderDetail.setQtyProduct(rs.getInt("qty_product"));

			// orderDetail.setLisProducts();
			product.setIdProduct(rs.getInt("id_product"));
			product.setType(rs.getString("type"));
			product.setPrice(rs.getDouble("price"));
			orderDetail.setProduct(product);

			brand.setBrand(rs.getString("brand"));
			product.setBrand(brand);
			orderDetail.setProduct(product);

			order.setSubtotal(rs.getDouble("subtotal"));
			orderDetail.setOrder(order);
			listCart.add(orderDetail);
		}
		return listCart;
	}

	// @Override
	// public List<OrderDetail> orderDetailById(int a) throws Exception {
	// 	List<OrderDetail> listCart = new ArrayList<OrderDetail>();
	// 	String sql = "select od.id_order, od.id_product, b.brand, p.type, p.price, od.qty_product, SUM(p.price*od.qty_product) subtotal from tb_order_detail od INNER JOIN tb_product p ON od.id_product = p.id_product INNER JOIN tb_brand b ON p.id_brand = b.id_brand where id_order=(select id_order from tb_order where id_user=?)";
	// 	PreparedStatement pst = this.conn.prepareStatement(sql);
	// 	pst.setInt(1, a);
	// 	ResultSet rs = pst.executeQuery();
	// 	Product product = new Product();
	// 	Brand brand = new Brand();
	// 	Order order = new Order();
	// 	while(rs.next()) {
	// 		OrderDetail orderDetail = new OrderDetail();
	// 		order.setIdOrder(rs.getInt("id_order"));
	// 		orderDetail.setOrder(order);
	// 		orderDetail.setQtyProduct(rs.getInt("qty_product"));

	// 		// orderDetail.setLisProducts();
	// 		product.setIdProduct(rs.getInt("id_product"));
	// 		product.setType(rs.getString("type"));
	// 		product.setPrice(rs.getDouble("price"));
	// 		orderDetail.setProduct(product);

	// 		brand.setBrand(rs.getString("brand"));
	// 		product.setBrand(brand);
	// 		orderDetail.setProduct(product);

	// 		order.setSubtotal(rs.getDouble("subtotal"));
	// 		orderDetail.setOrder(order);
	// 		listCart.add(orderDetail);
	// 	}
	// 	return listCart;
	// }

	@Override
	public OrderDetail max() throws Exception{
		OrderDetail orderDetail = null;
		String sql = "select max(id_order) from tb_order";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			orderDetail = new OrderDetail();
			Order order = new Order();
			orderDetail.setOrder(order);			
		}
		return orderDetail;
	}

	@Override
	public List<OrderDetail> orderDetailFindAll() throws Exception {
		List<OrderDetail> listOfOrderDetail = new ArrayList<OrderDetail>();
		String sql = "select id_order, id_product, qty_product from tb_order_detail";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			OrderDetail orderDetail = new OrderDetail();
			Order order = new Order();
			Product product = new Product();

			order.setIdOrder(rs.getInt("id_order"));
			orderDetail.setOrder(order);			

			product.setIdProduct(rs.getInt("id_product"));
			orderDetail.setProduct(product);
			
            orderDetail.setQtyProduct(rs.getInt("qty_product"));
			listOfOrderDetail.add(orderDetail);
		}
		return listOfOrderDetail;
	}

}
