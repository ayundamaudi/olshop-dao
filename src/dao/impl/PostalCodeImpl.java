package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.PostalCodeDAO;
import entity.PostalCode;

public class PostalCodeImpl implements PostalCodeDAO{
    private Connection conn;
	
	public PostalCodeImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int postalCodeInsert(PostalCode postalCode) throws Exception {
		String sql = "insert into tb_postal_code(postal_code, city, province) values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, postalCode.getPostalCode());
        pst.setString(2, postalCode.getCity());
        pst.setString(3, postalCode.getProvince());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int postalCodeUpdate(PostalCode postalCode) throws Exception {
		String sql = "update tb_postal_code set city=?, province=? where postal_code=?";
		PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, postalCode.getCity());
        pst.setString(2, postalCode.getProvince());
        pst.setInt(3, postalCode.getPostalCode());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int postalCodeDelete(int idPostalCode) throws Exception{
		String sql = "delete from tb_postal_code where postal_code=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idPostalCode);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public PostalCode postalCodeFindById(int idPostalCode) throws Exception{
		PostalCode postalCode = null;
		String sql = "select postal_code, city, province from tb_postal_code where postal_code=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idPostalCode);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			postalCode = new PostalCode();
			postalCode.setPostalCode(rs.getInt("postal_code"));
			postalCode.setCity(rs.getString("city"));
			postalCode.setProvince(rs.getString("province"));
		}
		return postalCode;
	}

	@Override
	public List<PostalCode> postalCodeFindAll() throws Exception {
		List<PostalCode> listOfPostalCode = new ArrayList<PostalCode>();
		String sql = "select postal_code, city, province from tb_postal_code";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			PostalCode postalCode = new PostalCode();
			postalCode.setPostalCode(rs.getInt("postal_code"));
			postalCode.setCity(rs.getString("city"));
			postalCode.setProvince(rs.getString("province"));
			listOfPostalCode.add(postalCode);
		}
		return listOfPostalCode;
	}
}
