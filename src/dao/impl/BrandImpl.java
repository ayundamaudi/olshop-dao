package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;
import dao.BrandDAO;

public class BrandImpl implements BrandDAO {
    private Connection conn;
	
	public BrandImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int brandInsert(Brand brand) throws Exception {
		String sql = "insert into tb_brand(brand) values(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, brand.getBrand());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int brandUpdate(Brand brand) throws Exception {
		String sql = "update tb_brand set brand=? where id_brand=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, brand.getBrand());
		pst.setInt(2, brand.getIdBrand());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int brandDelete(int idBrand) throws Exception{
		String sql = "delete from tb_brand where id_brand=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idBrand);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Brand brandFindById(int idBrand) throws Exception{
		Brand brand = null;
		String sql = "select id_brand, brand from tb_brand where id_brand=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idBrand);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			brand = new Brand();
			brand.setIdBrand(rs.getInt("id_brand"));
			brand.setBrand(rs.getString("brand"));
		}
		return brand;
	}

	@Override
	public List<Brand> brandFindAll() throws Exception {
		List<Brand> listOfbrand = new ArrayList<Brand>();
		String sql = "select id_brand, brand from tb_brand";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setIdBrand(rs.getInt("id_brand"));
			brand.setBrand(rs.getString("brand"));
			listOfbrand.add(brand);
		}
		return listOfbrand;
	}
}