package com.java.springhibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.springhibernate.model.Purchase;

@Repository
public class PurchaseDaoImpl  implements PurchaseDao{
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void addPurchase(Purchase purchase) {
		sessionfactory.getCurrentSession().saveOrUpdate(purchase);
		
	}

	@Override
	public Purchase getPurchase(int pid) {
		return (Purchase)sessionfactory.getCurrentSession().get(Purchase.class, pid);
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		sessionfactory.getCurrentSession().createQuery("delete from Purchase where pid="+purchase.getPid()).executeUpdate();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Purchase> listPurchase() {
		return sessionfactory.getCurrentSession().createCriteria(Purchase.class).list();
	}
	
	
	
}
