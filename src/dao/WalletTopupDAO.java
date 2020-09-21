package dao;

import java.util.List;

import entity.WalletTopup;

public interface WalletTopupDAO {
    public int walletTopupInsert(WalletTopup walletTopup) throws Exception;

	public int walletTopupUpdate(WalletTopup walletTopup) throws Exception;

	public int walletTopupDelete(int idTopup) throws Exception;

	public WalletTopup walletTopupFindById(int idTopup) throws Exception;

	public List<WalletTopup> walletTopupFindAll() throws Exception;
}
