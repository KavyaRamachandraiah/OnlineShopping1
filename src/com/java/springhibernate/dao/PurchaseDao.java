package com.java.springhibernate.dao;

import java.util.List;

import com.java.springhibernate.model.Purchase;

public interface PurchaseDao {

	public void addPurchase(Purchase purchase);
	public Purchase getPurchase(int pid);
	public void deletePurchase(Purchase purchase);
	public List<Purchase> listPurchase();
}
