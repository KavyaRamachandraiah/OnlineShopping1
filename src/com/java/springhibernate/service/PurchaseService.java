package com.java.springhibernate.service;

import java.util.List;

import com.java.springhibernate.model.Purchase;

public interface PurchaseService {
	public void addPurchase(Purchase purchase);
	public Purchase getPurchase(int pid);
	public void deletePurchase(Purchase purchase);
	public List<Purchase> listPurchase();
}
