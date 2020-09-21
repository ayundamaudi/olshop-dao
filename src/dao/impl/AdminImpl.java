package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDAO;
import entity.Admin;

public class AdminImpl implements AdminDAO {
    private Connection conn;
	
	public AdminImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int adminInsert(Admin admin) throws Exception {
		String sql = "insert into tb_admin(username_admin, name_admin, password_admin) values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, admin.getUsernameAdmin());
        pst.setString(2, admin.getNameAdmin());
        pst.setString(3, admin.getPasswordAdmin());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int adminUpdate(Admin admin) throws Exception {
		String sql = "update tb_admin set username_admin=?, name_admin=?, password_admin=? where id_admin=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, admin.getUsernameAdmin());
		pst.setString(2, admin.getNameAdmin());
        pst.setString(3, admin.getPasswordAdmin());
        pst.setInt(4, admin.getIdAdmin());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int adminDelete(int idAdmin) throws Exception{
		String sql = "delete from tb_admin where id_admin=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idAdmin);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Admin adminFindById(int idAdmin) throws Exception{
		Admin admin = null;
		String sql = "select id_admin, username_admin, name_admin, password_admin from tb_admin where id_admin=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idAdmin);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			admin = new Admin();
			admin.setIdAdmin(rs.getInt("id_admin"));
			admin.setUsernameAdmin(rs.getString("username_admin"));
			admin.setNameAdmin(rs.getString("name_admin"));
			admin.setPasswordAdmin(rs.getString("password_admin"));
		}
		return admin;
	}

	@Override
	public List<Admin> adminFindAll() throws Exception {
		List<Admin> listOfAdmin = new ArrayList<Admin>();
		String sql = "select id_admin, username_admin, name_admin, password_admin from tb_admin";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Admin admin = new Admin();
			admin.setIdAdmin(rs.getInt("id_admin"));
			admin.setUsernameAdmin(rs.getString("username_admin"));
			admin.setNameAdmin(rs.getString("name_admin"));
			admin.setPasswordAdmin(rs.getString("password_admin"));
			listOfAdmin.add(admin);
		}
		return listOfAdmin;
	}
}
