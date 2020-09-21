package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.WalletSendDAO;
import entity.WalletSend;

public class WalletSendImpl implements WalletSendDAO {
    private Connection conn;
	
	public WalletSendImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int walletSendInsert(WalletSend walletSend) throws Exception {
		String sql = "insert into tb_wallet_send(amount_wallet_send, created_wallet_send, to_user, to_wallet, from_user, from_wallet) values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, walletSend.getAmountWalletSend());
        pst.setTimestamp(2, walletSend.getCreatedWalletSend());
        pst.setObject(3, walletSend.getToUser());
		pst.setObject(4, walletSend.getToWallet());
        pst.setObject(5, walletSend.getFormUser());
        pst.setObject(6, walletSend.getFormWallet());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletSendUpdate(WalletSend walletSend) throws Exception {
		String sql = "update tb_wallet_send set amount_wallet_send=?, created_wallet_send=?, to_user=?, to_wallet=?, from_user=?, from_wallet=? where id_wallet_send=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, walletSend.getAmountWalletSend());
        pst.setTimestamp(2, walletSend.getCreatedWalletSend());
        pst.setObject(3, walletSend.getToUser());
		pst.setObject(4, walletSend.getToWallet());
        pst.setObject(5, walletSend.getFormUser());
        pst.setObject(6, walletSend.getFormWallet());
        pst.setInt(7, walletSend.getIdWalletSend());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletSendDelete(int idWalletSend) throws Exception{
		String sql = "delete from tb_wallet_send where id_wallet_send=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idWalletSend);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public WalletSend walletSendFindById(int idWalletSend) throws Exception{
		WalletSend walletSend = null;
		String sql = "select id_wallet_send, amount_wallet_send, created_wallet_send, to_user, to_wallet, from_user, from_wallet from tb_wallet_send where id_wallet_send=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idWalletSend);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			walletSend = new WalletSend();
			walletSend.setIdWalletSend(rs.getInt("id_wallet_send"));
			walletSend.setAmountWalletSend(rs.getDouble("amount_wallet_send"));
			walletSend.setIdWalletSend(rs.getTimestamp("created_wallet_send"));
			walletSend.setToUser(rs.getInt("to_user"));
			walletSend.setToWallet(rs.getString("to_wallet"));
			walletSend.setFormUser(rs.getInt("from_user"));
			walletSend.setFormWallet(rs.getString("from_wallet"));
		}
		return walletSend;
	}

	@Override
	public List<WalletSend> walletSendFindAll() throws Exception {
		List<WalletSend> listOfWalletSend = new ArrayList<WalletSend>();
		String sql = "select id_wallet_send, amount_wallet_send, created_wallet_send, to_user, to_wallet, from_user, from_wallet from tb_wallet_send";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WalletSend walletSend = new WalletSend();
			walletSend = new WalletSend();
			walletSend.setIdWalletSend(rs.getInt("id_wallet_send"));
			walletSend.setAmountWalletSend(rs.getDouble("amount_wallet_send"));
			walletSend.setIdWalletSend(rs.getTimestamp("created_wallet_send"));
			walletSend.setToUser(rs.getInt("to_user"));
			walletSend.setToWallet(rs.getString("to_wallet"));
			walletSend.setFormUser(rs.getInt("from_user"));
			walletSend.setFormWallet(rs.getString("from_wallet"));
			listOfWalletSend.add(walletSend);
		}
		return listOfWalletSend;
	}

}
