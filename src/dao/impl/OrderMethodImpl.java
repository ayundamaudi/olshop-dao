package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.OrderMethodDAO;
import entity.OrderMethod;

public class OrderMethodImpl implements OrderMethodDAO{
    private Connection conn;
	
	public OrderMethodImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int orderMethodInsert(OrderMethod orderMethod) throws Exception {
		String sql = "insert into tb_order_method(method) values(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, orderMethod.getMethod());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int orderMethodUpdate(OrderMethod orderMethod) throws Exception {
		String sql = "update tb_order_method set method=? where id_method=?";
		PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, orderMethod.getMethod());
        pst.setInt(2, orderMethod.getIdMethod());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int orderMethodDelete(int idMethod) throws Exception{
		String sql = "delete from tb_order_method where id_method=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idMethod);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public OrderMethod orderMethodFindById(int idMethod) throws Exception{
		OrderMethod orderMethod = null;
		String sql = "select id_method, method where id_method=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idMethod);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			orderMethod = new OrderMethod();
			orderMethod.setIdMethod(rs.getInt("id_method"));
			orderMethod.setMethod(rs.getString("method"));
        }
		return orderMethod;
	}

	@Override
	public List<OrderMethod> orderMethodFindAll() throws Exception {
		List<OrderMethod> listOfOrderMethod = new ArrayList<OrderMethod>();
		String sql = "select id_method, method from tb_order_method";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			OrderMethod orderMethod = new OrderMethod();
            orderMethod.setIdMethod(rs.getInt("id_method"));
			orderMethod.setMethod(rs.getString("method"));
            listOfOrderMethod.add(orderMethod);
		}
		return listOfOrderMethod;
	}

}
