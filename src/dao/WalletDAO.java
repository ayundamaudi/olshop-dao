package dao;

import java.util.List;

import entity.Wallet;

public interface WalletDAO {
    public int walletInsert(Wallet wallet) throws Exception;

	public int walletUpdate(Wallet wallet) throws Exception;

	public int walletDelete(int idWallet) throws Exception;

	public Wallet walletFindById(int idWallet) throws Exception;

	public List<Wallet> walletFindAll() throws Exception;
}
