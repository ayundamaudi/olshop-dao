package dao;

import java.util.List;

import entity.WalletPayment;

public interface WalletPaymentDAO {
    public int walletPaymentInsert(WalletPayment walletPayment) throws Exception;

	public int walletPaymentUpdate(WalletPayment walletPayment) throws Exception;

	public int walletPaymentDelete(int idPay) throws Exception;

	public WalletPayment walletPaymentFindById(int idPay) throws Exception;

	public List<WalletPayment> walletPaymentFindAll() throws Exception;
}
