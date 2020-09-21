package dao;

import java.util.List;

import entity.WalletSend;

public interface WalletSendDAO {
    public int walletSendInsert(WalletSend walletSend) throws Exception;

	public int walletSendUpdate(WalletSend walletSend) throws Exception;

	public int walletSendDelete(int idWalletSend) throws Exception;

	public WalletSend walletSendFindById(int idWalletSend) throws Exception;

	public List<WalletSend> walletSendFindAll() throws Exception;
}
