package com.java.springhibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.springhibernate.model.Item;

@Repository
public class ItemDaoImpl  implements ItemDao{
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void additem(Item item) {
		sessionfactory.getCurrentSession().saveOrUpdate(item);
		
	}

	@Override
	public Item getitem(int itemid) {
		return (Item)sessionfactory.getCurrentSession().get(Item.class, itemid);
	}

	@Override
	public void deleteitem(Item item) {
		sessionfactory.getCurrentSession().createQuery("delete from Item where itemid="+item.getItemid()).executeUpdate();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> listitem() {
		return sessionfactory.getCurrentSession().createCriteria(Item.class).list();
	}
	

}
