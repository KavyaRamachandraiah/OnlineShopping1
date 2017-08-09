package com.java.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.springhibernate.dao.PurchaseDao;
import com.java.springhibernate.model.Purchase;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private PurchaseDao purchasedao;

	@Override
	public void addPurchase(Purchase purchase) {
		purchasedao.addPurchase(purchase);
		
	}

	@Override
	public Purchase getPurchase(int pid) {
		return purchasedao.getPurchase(pid);
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		purchasedao.deletePurchase(purchase);
	}

	@Override
	public List<Purchase> listPurchase() {
		return purchasedao.listPurchase();
	}
	
	
}
