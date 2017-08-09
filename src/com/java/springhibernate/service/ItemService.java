package com.java.springhibernate.service;

import java.util.List;

import com.java.springhibernate.model.Item;

public interface ItemService {

	public void additem(Item item);
	public Item getitem(int itemid);
	public void deleteitem(Item item);
	public List<Item> listitem();
}
