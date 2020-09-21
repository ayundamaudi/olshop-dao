package dao;

import java.util.List;

import entity.PostalCode;

public interface PostalCodeDAO {
    public int postalCodeInsert(PostalCode postalCode) throws Exception;

	public int postalCodeUpdate(PostalCode postalCode) throws Exception;

	public int postalCodeDelete(int idPostalCode) throws Exception;

	public PostalCode postalCodeFindById(int idPostalCode) throws Exception;

	public List<PostalCode> postalCodeFindAll() throws Exception;
}
