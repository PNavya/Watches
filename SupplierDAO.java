package com.niit.ShoppingCart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ShoppingCart.model.Supplier;

@Repository
public interface SupplierDAO {

	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String supId);
	public List<Supplier> list();

	
}
