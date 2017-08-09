package com.java.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.springhibernate.dao.ItemDao;
import com.java.springhibernate.model.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
 private ItemDao itemdao;

@Override
public void additem(Item item) {
	itemdao.additem(item);
	
}

@Override
public Item getitem(int itemid) {
	return itemdao.getitem(itemid);
}

@Override
public void deleteitem(Item item) {
	itemdao.deleteitem(item);
}

@Override
public List<Item> listitem() {
	return itemdao.listitem();
}
 
}
