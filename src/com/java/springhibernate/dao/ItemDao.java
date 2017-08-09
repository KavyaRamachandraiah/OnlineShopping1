package com.java.springhibernate.dao;

import java.util.List;

import com.java.springhibernate.model.Item;

public interface ItemDao {

	public void additem(Item item);
	public Item getitem(int itemid);
	public void deleteitem(Item item);
	public List<Item> listitem();
}
