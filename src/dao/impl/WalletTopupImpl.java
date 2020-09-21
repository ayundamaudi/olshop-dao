package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.WalletTopupDAO;
import entity.WalletTopup;

public class WalletTopupImpl implements WalletTopupDAO {
    private Connection conn;
	
	public WalletTopupImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int walletTopupInsert(WalletTopup walletTopup) throws Exception {
		String sql = "insert into tb_wallet_topup(no_account_topup, amount_topup, created_topup, id_user, id_wallet) values(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, walletTopup.getNoAccountTopup());
        pst.setDouble(2, walletTopup.getAmountTopup());
        pst.setTimestamp(3, walletTopup.getCreatedTopup());
        pst.setObject(2, walletTopup.getIdUser());
        pst.setObject(3, walletTopup.getIdWallet());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletTopupUpdate(WalletTopup walletTopup) throws Exception {
		String sql = "update tb_wallet_topup set no_account_topup=?, amount_topup=?, created_topup=?, id_user=?, id_wallet=? where id_topup=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, walletTopup.getNoAccountTopup());
		pst.setDouble(2, walletTopup.getAmountTopup());
        pst.setTimestamp(3, walletTopup.getCreatedTopup());
        pst.setObject(4, walletTopup.getIdUser());
        pst.setObject(5, walletTopup.getIdWallet());
        pst.setInt(6, walletTopup.getIdTopup());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletTopupDelete(int idTopup) throws Exception{
		String sql = "delete from tb_wallet_topup where id_topup=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idTopup);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public WalletTopup walletTopupFindById(int idTopup) throws Exception{
		WalletTopup walletTopup = null;
		String sql = "select id_topup, no_account_topup, amount_topup, created_topup, id_user, id_wallet from tb_wallet_topup where id_topup=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idTopup);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			walletTopup = new WalletTopup();
			walletTopup.setIdTopup(rs.getInt("id_topup"));
			walletTopup.setNoAccountTopup(rs.getString("no_account_topup"));
			walletTopup.setAmountTopup(rs.getDouble("amount_topup"));
			walletTopup.setCreatedTopup(rs.getTimestamp("created_topup"));
			walletTopup.setIdUser(rs.getInt("id_user"));
			walletTopup.setIdWallet(rs.getString("id_wallet")));
		}
		return walletTopup;
	}

	@Override
	public List<WalletTopup> walletTopupFindAll() throws Exception {
		List<WalletTopup> listOfWalletTopup = new ArrayList<WalletTopup>();
		String sql = "select id_topup, no_account_topup, amount_topup, created_topup, id_user, id_wallet from tb_wallet_topup";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WalletTopup walletTopup = new WalletTopup();
			walletTopup.setIdTopup(rs.getInt("id_topup"));
			walletTopup.setNoAccountTopup(rs.getString("no_account_topup"));
			walletTopup.setAmountTopup(rs.getDouble("amount_topup"));
			walletTopup.setCreatedTopup(rs.getTimestamp("created_topup"));
			walletTopup.setIdUser(rs.getInt("id_user"));
			walletTopup.setIdWallet(rs.getString("id_wallet")));
			listOfWalletTopup.add(walletTopup);
		}
		return listOfWalletTopup;
	}

}
