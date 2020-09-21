package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.WalletPaymentDAO;
import entity.WalletPayment;

public class WalletPaymentImpl implements WalletPaymentDAO {
    private Connection conn;
	
	public WalletPaymentImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int walletPaymentInsert(WalletPayment walletPayment) throws Exception {
		String sql = "insert into tb_wallet_payment(amount_pay, created_pay, id_user, id_wallet, id_order) values(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, walletPayment.getAmountPay());
        pst.setTimestamp(2, walletPayment.getCreatedPay());
        pst.setObject(3, walletPayment.getIdUser());
        pst.setObject(4, walletPayment.getIdWallet());
        pst.setObject(5, walletPayment.getIdWallet());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletPaymentUpdate(WalletPayment walletPayment) throws Exception {
		String sql = "update tb_wallet_payment set amount_pay=?, created_pay=?, id_user=?, id_wallet=?, id_order=? where id_pay=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, walletPayment.getAmountPay());
		pst.setTimestamp(2, walletPayment.getCreatedPay());
        pst.setObject(3, walletPayment.getIdUser());
        pst.setObject(4, walletPayment.getIdWallet());
        pst.setObject(5, walletPayment.getIdOrder());
        pst.setInt(6, walletPayment.getIdPay());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletPaymentDelete(int idPay) throws Exception{
		String sql = "delete from tb_wallet_payment where id_pay=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idPay);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public WalletPayment walletPaymentFindById(int idPay) throws Exception{
		WalletPayment walletPayment = null;
		String sql = "select id_pay, amount_pay, created_pay, id_user, id_wallet, id_order from tb_wallet_payment where id_pay=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idPay);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			walletPayment = new WalletPayment();
			walletPayment.setIdPay(rs.getInt("id_pay"));
			walletPayment.setAmountPay(rs.getDouble("amount_pay"));
			walletPayment.setCreatedPay(rs.getTimestamp("created_pay"));
			walletPayment.setIdUser(rs.getInt("id_user"));
			walletPayment.setIdWallet(rs.getString("id_wallet"));
			walletPayment.setIdOrder(rs.getInt("id_order"));
		}
		return walletPayment;
	}

	@Override
	public List<WalletPayment> walletPaymentFindAll() throws Exception {
		List<WalletPayment> listOfWalletPayment = new ArrayList<WalletPayment>();
		String sql = "select id_pay, amount_pay, created_pay, id_user, id_wallet, id_order from tb_wallet_payment";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WalletPayment walletPayment = new WalletPayment();
			walletPayment.setIdPay(rs.getInt("id_pay"));
			walletPayment.setAmountPay(rs.getDouble("amount_pay"));
			walletPayment.setCreatedPay(rs.getTimestamp("created_pay"));
			walletPayment.setIdUser(rs.getInt("id_user"));
			walletPayment.setIdWallet(rs.getString("id_wallet"));
			walletPayment.setIdOrder(rs.getInt("id_order"));
			listOfWalletPayment.add(walletPayment);
		}
		return listOfWalletPayment;
	}

}
