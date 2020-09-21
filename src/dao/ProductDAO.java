package dao;

import java.util.List;

import entity.Product;

public interface ProductDAO {
    public int ProductInsert(Product product) throws Exception;

	public int ProductUpdate(Product product) throws Exception;

	public int ProductDelete(int idProduct) throws Exception;

	public Product ProductFindById(int idProduct) throws Exception;
	
	public List<Product> ProductFindByIdProduct(int idProduct) throws Exception;
	
	public List<Product> ProductFindBySearch(String param) throws Exception;

	public List<Product> ProductNewMonth() throws Exception;

	public List<Product> ProductFindAll() throws Exception;

	public List<Product> ProductBestSeller() throws Exception;
	
}
