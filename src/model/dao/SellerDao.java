package model.dao;

import java.util.List;

import model.Entities.Seller;

public interface SellerDao {
	void insert(Seller obj);
	 void update(Seller obj);
	 void deletebyid(Integer id);
	 Seller findById(Integer id); 
	 List <Seller> findAll();

}
