package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TransferDAO;
import entity.Transfer;

public class TransferImpl implements TransferDAO{
    private Connection conn;
	
	public TransferImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int transferInsert(Transfer transfer) throws Exception {
		String sql = "insert into tb_transfer(no_account, amount_transfer, created_transfer, id_order, id_user) values(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, transfer.getNoAccount());
        pst.setDouble(2, transfer.getAmountTransfer());
        pst.setTimestamp(3, transfer.getCreatedTransfer());
        pst.setObject(4, transfer.getIdOrder());
        pst.setObject(5, transfer.getIdUser());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int transferUpdate(Transfer transfer) throws Exception {
		String sql = "update tb_transfer set no_account=?, amount_transfer=?, created_transfer=?, id_order=?, id_user=? where id_transfer=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, transfer.getNoAccount());
        pst.setDouble(2, transfer.getAmountTransfer());
        pst.setTimestamp(3, transfer.getCreatedTransfer());
        pst.setObject(4, transfer.getIdOrder());
        pst.setObject(5, transfer.getIdUser());
        pst.setInt(6, transfer.getIdTransfer());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int transferDelete(int idTransfer) throws Exception{
		String sql = "delete from tb_transfer where id_transfer=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idTransfer);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public Transfer transferFindById(int idTransfer) throws Exception{
		Transfer transfer = null;
		String sql = "select id_transfer, no_account, amount_transfer, created_transfer, id_order, id_user from tb_transfer where id_transfer=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, idTransfer);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			transfer = new Transfer();
			transfer.setIdTransfer(rs.getInt("id_transfer"));
			transfer.setNoAccount(rs.getString("no_account"));
			transfer.setAmountTransfer(rs.getDouble("amount_transfer"));
			transfer.setCreatedTransfer(rs.getTimestamp("created_transfer"));
			transfer.setIdOrder(rs.getInt("id_order"));
			transfer.setIdUser(rs.getInt("id_user"));
		}
		return transfer;
	}

	@Override
	public List<Transfer> transferFindAll() throws Exception {
		List<Transfer> listOfTransfer = new ArrayList<Transfer>();
		String sql = "select id_transfer, no_account, amount_transfer, created_transfer, id_order, id_user from tb_transfer";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Transfer transfer = new Transfer();
			transfer.setIdTransfer(rs.getInt("id_transfer"));
			transfer.setNoAccount(rs.getString("no_account"));
			transfer.setAmountTransfer(rs.getDouble("amount_transfer"));
			transfer.setCreatedTransfer(rs.getTimestamp("created_transfer"));
			transfer.setIdOrder(rs.getInt("id_order"));
			transfer.setIdUser(rs.getInt("id_user"));
			listOfTransfer.add(transfer);
		}
		return listOfTransfer;
	}

}
