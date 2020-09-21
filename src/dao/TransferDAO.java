package dao;

import java.util.List;

import entity.Transfer;

public interface TransferDAO {
    public int transferInsert(Transfer transfer) throws Exception;

	public int transferUpdate(Transfer transfer) throws Exception;

	public int transferDelete(int idTransfer) throws Exception;

	public Transfer transferFindById(int idTransfer) throws Exception;

	public List<Transfer> transferFindAll() throws Exception;
}
