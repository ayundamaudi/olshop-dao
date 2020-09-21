package dao;

import java.util.List;

import entity.OrderDetail;

public interface OrderDetailDAO {
    public int orderDetailInsert(OrderDetail orderDetail) throws Exception;

	public int orderDetailUpdate(OrderDetail orderDetail) throws Exception;

	public int orderDetailDelete(int idOrder) throws Exception;

	public OrderDetail orderDetailFindById(int idOrder) throws Exception;

	public OrderDetail max() throws Exception;

	public List<OrderDetail> orderDetailById() throws Exception;

	public List<OrderDetail> orderDetailFindAll() throws Exception;
}
