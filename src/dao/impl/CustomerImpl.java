package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAO;
import entity.Address;
import entity.Customer;
import entity.PostalCode;

public class CustomerImpl implements CustomerDAO{
    private Connection conn;
	
	public CustomerImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int customerInsert(Customer customer) throws Exception {
		String sql = "insert into tb_customer (email_user, password_user, name_user,  created_user) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, customer.getEmailUser());
        pst.setString(2, customer.getPasswordUser());
        pst.setString(3, customer.getNameUser());
        pst.setTimestamp(4, customer.getCreatedUser());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int addressInsertCustomer(Customer customer) throws Exception {
		String sql = "insert into tb_address (address, postal_code,id_user, no_tlp) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, customer.getAddress().getAddress());
		pst.setInt(2, customer.getPostalCode().getPostalCode());
		pst.setInt(3, customer.getIdUser());
		pst.setString(4, customer.getAddress().getNoTlp());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int customerUpdate(Customer customer) throws Exception {
		String sql = "update tb_customer set password_user=?, email_user=?, name_user=? where id_user=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, customer.getPasswordUser());
		pst.setString(2, customer.getEmailUser());
		pst.setString(3, customer.getNameUser());
        pst.setInt(4, customer.getIdUser());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int customerUpdatePassword(Customer customer) throws Exception {
		String sql = "update tb_customer set password_user=? where id_user=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, customer.getPasswordUser());
        pst.setInt(2, customer.getIdUser());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int customerUpdateAddress(Customer customer) throws Exception {
		String sql = "update tb_address set address=?, postal_code=?, no_tlp=? where id_user=? && id_address=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, customer.getAddress().getAddress());
		pst.setInt(2, customer.getPostalCode().getPostalCode());
		pst.setString(3, customer.getAddress().getNoTlp());
		pst.setInt(4, customer.getIdUser());
		pst.setInt(5, customer.getAddress().getIdAddress());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int customerDelete(int idCustomer) throws Exception{
		String sql = "delete from tb_customer where id_user=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idCustomer);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Customer customerFindById(int idCustomer) throws Exception{
		Customer customer = null;
		String sql = "SELECT u.id_user, u.name_user, u.email_user, u.password_user,  adr.address, p.postal_code, p.city, p.province FROM tb_customer u LEFT OUTER JOIN tb_address adr ON u.id_user = adr.id_user LEFT OUTER JOIN tb_postal_code p ON adr.postal_code = p.postal_code where u.id_user=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idCustomer);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			customer = new Customer();
			Address address = new Address();
			PostalCode postalCode = new PostalCode();

			customer.setIdUser(rs.getInt("id_user"));
			customer.setNameUser(rs.getString("name_user"));
			customer.setEmailUser(rs.getString("email_user"));
			customer.setPasswordUser(rs.getString("password_user"));

			address.setAddress(rs.getString("address"));
			customer.setAddress(address);

			postalCode.setPostalCode(rs.getInt("postal_code"));
			postalCode.setCity(rs.getString("city"));
			postalCode.setProvince(rs.getString("province"));
			customer.setPostalCode(postalCode);

		}
		return customer;
	}

	@Override
	public List<Customer> customerFindAll() throws Exception {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		String sql = "SELECT u.id_user, u.name_user, u.email_user, u.password_user, adr.address, adr.no_tlp, p.postal_code, p.city, p.province FROM tb_customer u LEFT OUTER JOIN tb_address adr ON u.id_user = adr.id_user LEFT OUTER JOIN tb_postal_code p ON adr.postal_code = p.postal_code";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Customer customer = new Customer();
			Address address = new Address();
			PostalCode postalCode = new PostalCode();

			customer.setIdUser(rs.getInt("id_user"));
			customer.setNameUser(rs.getString("name_user"));
			customer.setEmailUser(rs.getString("email_user"));
			customer.setPasswordUser(rs.getString("password_user"));

			address.setAddress(rs.getString("address"));
			address.setNoTlp(rs.getString("no_tlp"));
			customer.setAddress(address);

			postalCode.setPostalCode(rs.getInt("postal_code"));
			postalCode.setCity(rs.getString("city"));
			postalCode.setProvince(rs.getString("province"));
			customer.setPostalCode(postalCode);

			listOfCustomer.add(customer);
		}
		return listOfCustomer;
	}
}
