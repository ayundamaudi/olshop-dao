package dao;

import java.util.List;

import entity.Address;

public interface AddressDAO {
    public int addressInsert(Address address) throws Exception;

	public int addressUpdate(Address address) throws Exception;

	public int addressDelete(int idUser) throws Exception;

	public List<Address> addressFindByIdUser(int idUser) throws Exception;

	public Address addressFindById(int idUser) throws Exception;

	public List<Address> addressFindAll() throws Exception;
}
