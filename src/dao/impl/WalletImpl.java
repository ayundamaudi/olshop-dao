package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.WalletDAO;
import entity.Wallet;

public class WalletImpl implements WalletDAO{
    private Connection conn;
	
	public WalletImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int walletInsert(Wallet wallet) throws Exception {
		String sql = "insert into tb_wallet(current_balance, id_user) values(?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, wallet.getCurrentBalance());
        pst.setObject(2, wallet.getIdUser());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletUpdate(Wallet wallet) throws Exception {
		String sql = "update tb_wallet set current_balance=?, id_user=? where id_wallet=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, wallet.getCurrentBalance());
		pst.setObject(2, wallet.getIdUser());
        pst.setObject(3, wallet.getIdWallet());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int walletDelete(int idWallet) throws Exception{
		String sql = "delete from tb_wallet where id_wallet=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idWallet);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Wallet walletFindById(int idWallet) throws Exception{
		Wallet wallet = null;
		String sql = "select id_wallet, current_balance, id_user from tb_wallet where id_wallet=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idWallet);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			wallet = new Wallet();
			wallet.setIdWallet(rs.getString("id_wallet"));
			wallet.setCurrentBalance(rs.getString("current_balance"));
			wallet.setIdUser(rs.getString("id_user"));
		}
		return wallet;
	}

	@Override
	public List<Wallet> walletFindAll() throws Exception {
		List<Wallet> listOfWallet = new ArrayList<Wallet>();
		String sql = "select id_wallet, current_balance, id_user from tb_wallet";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Wallet wallet = new Wallet();
			wallet.setIdWallet(rs.getString("id_wallet"));
			wallet.setCurrentBalance(rs.getString("current_balance"));
			wallet.setIdUser(rs.getString("id_user"));
			listOfWallet.add(wallet);
		}
		return listOfWallet;
	}
}
