package dao;

import java.util.List;

import entity.Customer;

public interface CustomerDAO {
    public int customerInsert(Customer Customer) throws Exception;

	public int customerUpdate(Customer Customer) throws Exception;

	public int customerUpdateAddress(Customer Customer) throws Exception;

	public int customerUpdatePassword(Customer Customer) throws Exception;

	public int customerDelete(int idCustomer) throws Exception;

	public Customer customerFindById(int idCustomer) throws Exception;

	public List<Customer> customerFindAll() throws Exception;

	public int addressInsertCustomer(Customer customer) throws Exception;
}
