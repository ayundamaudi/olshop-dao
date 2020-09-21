package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.AddressDAO;
import entity.Address;
import entity.Customer;
import entity.PostalCode;

public class AddressImpl implements AddressDAO {
    private Connection conn;
	
	public AddressImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int addressInsert(Address address) throws Exception {
        String sql = "insert into tb_address(postal_code, id_user, address, no_tlp) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setObject(1, address.getPostalCode());
        pst.setObject(2, address.getCustomer());
		pst.setString(3, address.getAddress());
		pst.setString(4, address.getNoTlp());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int addressUpdate(Address address) throws Exception {
		String sql = "update tb_address set postal_code=?, address=?, no_tlp=? where id_user=? && id_addres=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setObject(1, address.getPostalCode());
		pst.setString(2, address.getAddress());
        pst.setObject(3, address.getNoTlp());
		pst.setInt(4, address.getCustomer().getIdUser());
		pst.setInt(4, address.getIdAddress());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int addressDelete(int idUser) throws Exception{
		String sql = "delete from tb_address where id_user=? && id_addres=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idUser);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public List<Address> addressFindByIdUser(int idUser) throws Exception {
		List<Address> listOfAddressCustomer = new ArrayList<Address>();
		String sql = "select a.id_address, a.postal_code, a.id_user, a.address, a.no_tlp, c.name_user, p.city, p.province from tb_address a INNER JOIN tb_customer c ON a.id_user = c.id_user INNER JOIN tb_postal_code p ON a.postal_code=p.postal_code where a.id_user=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, idUser);
		ResultSet rs = pst.executeQuery();
		
		PostalCode postalCode = new PostalCode();
		Customer customer = new Customer();
		while(rs.next()) {
			Address address = new Address();
			address.setIdAddress(rs.getInt("id_address"));

			postalCode.setPostalCode(rs.getInt("postal_code"));
			postalCode.setCity(rs.getString("city"));
			postalCode.setProvince(rs.getString("province"));
			address.setPostalCode(postalCode);
			
			customer.setIdUser(rs.getInt("id_user"));
			customer.setNameUser(rs.getString("name_user"));
			address.setCustomer(customer);

			address.setAddress(rs.getString("address"));
			address.setNoTlp(rs.getString("no_tlp"));
			listOfAddressCustomer.add(address);
		}
		return listOfAddressCustomer;
	}

	@Override
	public Address addressFindById(int idAddress) throws Exception {
		Address address = null;
		String sql = "select id_address, postal_code, id_user, address, no_tlp from tb_address where id_address=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, idAddress);
		ResultSet rs = pst.executeQuery();
		
		PostalCode postalCode = new PostalCode();
		Customer customer = new Customer();
		while(rs.next()) {
			address = new Address();
			address.setIdAddress(rs.getInt("id_address"));

			postalCode.setPostalCode(rs.getInt("postal_code"));
			address.setPostalCode(postalCode);
			
			customer.setIdUser(rs.getInt("id_user"));
			address.setCustomer(customer);

			address.setAddress(rs.getString("address"));
			address.setNoTlp(rs.getString("no_tlp"));
		}
		return address;
	}
	
	@Override
	public List<Address> addressFindAll() throws Exception {
		List<Address> listOfAddress = new ArrayList<Address>();
		String sql = "select postal_code, id_user, address, no_tlp from tb_address";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Address address = new Address();
			PostalCode postalCode = new PostalCode();
			Customer customer = new Customer();
			address.setIdAddress(rs.getInt("id_address"));

			postalCode.setPostalCode(rs.getInt("postal_code"));
			address.setPostalCode(postalCode);
			
			customer.setIdUser(rs.getInt("id_user"));
			address.setCustomer(customer);

			address.setAddress(rs.getString("address"));
			address.setNoTlp(rs.getString("no_tlp"));
		}
		return listOfAddress;
	}
}