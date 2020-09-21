package dao;

import java.util.List;

import entity.Brand;

public interface BrandDAO {
    public int brandInsert(Brand brand) throws Exception;

	public int brandUpdate(Brand brand) throws Exception;

	public int brandDelete(int idbrand) throws Exception;

	public Brand brandFindById(int idbrand) throws Exception;

	public List<Brand> brandFindAll() throws Exception;
}
