package dao;

import java.util.List;

import entity.OrderMethod;

public interface OrderMethodDAO {
    public int orderMethodInsert(OrderMethod orderMethod) throws Exception;

	public int orderMethodUpdate(OrderMethod orderMethod) throws Exception;

	public int orderMethodDelete(int idMeethod) throws Exception;

	public OrderMethod orderMethodFindById(int idMeethod) throws Exception;

	public List<OrderMethod> orderMethodFindAll() throws Exception;
}
