package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
    public int adminInsert(Admin admin) throws Exception;

	public int adminUpdate(Admin admin) throws Exception;

	public int adminDelete(int idAdmin) throws Exception;

	public Admin adminFindById(int idAdmin) throws Exception;

	public List<Admin> adminFindAll() throws Exception;
}
