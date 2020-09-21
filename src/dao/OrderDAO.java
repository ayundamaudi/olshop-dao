package dao;

import java.util.List;

import entity.Order;
import entity.Product;

public interface OrderDAO {
	public int orderInsert(Order order) throws Exception;
	
	public int orderInsertCustomer(Order order) throws Exception;

	public int orderUpdate(Order order) throws Exception;

	public int orderDelete(int idOrder) throws Exception;

	public Order orderFindByIdOrder(int idOrder) throws Exception;

	public Order orderFindByIdUser(int idOrder) throws Exception;

	public List<Order> orderFindAll() throws Exception;

	public List<Product> ProductFindAll() throws Exception;
}
