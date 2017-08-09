package com.java.springhibernate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.springhibernate.bean.CustomerBean;
import com.java.springhibernate.bean.ItemBean;
import com.java.springhibernate.bean.PurchaseBean;
import com.java.springhibernate.bean.PurchaseItem;
import com.java.springhibernate.model.Customer;
import com.java.springhibernate.model.Item;
import com.java.springhibernate.model.Purchase;
import com.java.springhibernate.service.CustomerService;
import com.java.springhibernate.service.ItemService;
import com.java.springhibernate.service.PurchaseService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	
	private HttpSession session;
	
	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private PurchaseService purchaseservice;
	
	@RequestMapping(value="/register")
	public ModelAndView register(@ModelAttribute("command") CustomerBean customerbean,BindingResult result){
		return new ModelAndView("register");
	}
	@RequestMapping(value="/loginpage")
	public ModelAndView loginpage(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView admin(){
		return new ModelAndView("admin");
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/login")
	public ModelAndView logincustomer(@ModelAttribute("command") CustomerBean customerbean,BindingResult result,HttpServletRequest request){
		List<CustomerBean> l=preparelistbean(customerservice.listofcustomer());
		if((l!=null )&& !(l.isEmpty())){
		Map model=new HashMap();
		CustomerBean c=null;
		Iterator i=l.iterator();
		while(i.hasNext()){
			c=(CustomerBean)i.next();
			if((c.getName().equals(customerbean.getName()))&&(c.getPassword().equals(customerbean.getPassword()))){
			
				session=request.getSession();
				session.setAttribute("custid", c.getId());
			model.put("customer",preparebean(customerservice.get(c.getId())));
			return new ModelAndView("display",model);
				}
			}
		}
		return new ModelAndView("error");
	}
	
	
	@RequestMapping(value="/add")
	public ModelAndView addcustomer(@ModelAttribute("command") CustomerBean customerbean,BindingResult result,HttpServletRequest request){
		
		Customer customer=preparemodel(customerbean);
		customerservice.add(customer);
		Map model=new HashMap();
		model.put("customer", preparebean(customerservice.get(preparebean(customer).getId())));
		session=request.getSession();
		session.setAttribute("custid",preparebean(customer).getId());
		return new ModelAndView("display",model);
		
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView editcustomer(@ModelAttribute("command") CustomerBean customerbean,BindingResult result){
		
		Map model=new HashMap();
		model.put("customer", 	preparebean(customerservice.get(customerbean.getId())));
		return new ModelAndView("register",model);
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView deletecustomer(@ModelAttribute("command") CustomerBean customerbean,BindingResult result){
		customerservice.delete(preparemodel(customerbean));
		return new ModelAndView("bye");		
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(@ModelAttribute("command") CustomerBean customerbean,BindingResult result){
		session=null;
		return new ModelAndView("thank");
	}
			
	public Customer preparemodel(CustomerBean customerbean){
		Customer customer=new Customer();
		customer.setId(customerbean.getId());
		customer.setName(customerbean.getName());
		customer.setPassword(customerbean.getPassword());
		customer.setAge(customerbean.getAge());
		customer.setEmail(customerbean.getEmail());
		return customer;
	}
	public CustomerBean preparebean(Customer customer){
		CustomerBean customerbean=new CustomerBean();
		customerbean.setId(customer.getId());
		customerbean.setName(customer.getName());
		customerbean.setPassword(customer.getPassword());
		customerbean.setAge(customer.getAge());
		customerbean.setEmail(customer.getEmail());
		return customerbean;
			}
	public List<CustomerBean> preparelistbean(List<Customer> customer){
		List<CustomerBean> beans=null;
		if((customer!=null)&&!(customer.isEmpty())){
			beans=new ArrayList<CustomerBean>();
			for(Customer c:customer ){
				CustomerBean bean=new CustomerBean();
				bean.setId(c.getId());
				bean.setName(c.getName());
				bean.setPassword(c.getPassword());
				bean.setAge(c.getAge());
				bean.setEmail(c.getEmail());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	@RequestMapping(value="/additem")
	public ModelAndView add(@ModelAttribute("command") ItemBean itembean,BindingResult result){
		Item item=prepareItemModel(itembean);
		itemservice.additem(item);
		
		Map model=new HashMap();
		model.put("items",prepareListBean(itemservice.listitem()) );
		return new ModelAndView("adminpage",model);
		
	}
	@RequestMapping(value="/items")
	public ModelAndView check(@ModelAttribute("command") ItemBean itembean,BindingResult result,HttpServletRequest request){
		if(request.getParameter("name").equals("admin")&& request.getParameter("password").equals("admin")){
			Map model=new HashMap();
			model.put("items",prepareListBean(itemservice.listitem()) );
			return new ModelAndView("adminpage",model);
		}
		return new ModelAndView("erroradmin");
	}
	
	@RequestMapping(value="/edititem")
	public ModelAndView edititem(@ModelAttribute("command") ItemBean itembean,BindingResult result){
		
		Map model=new HashMap();
		model.put("item", prepareItemBean(itemservice.getitem(itembean.getItemid())));
		model.put("items",prepareListBean(itemservice.listitem()) );
		return new ModelAndView("adminpage",model);
	}
	
	@RequestMapping(value="/deleteitem")
	public ModelAndView deleteitem(@ModelAttribute("command") ItemBean itembean,BindingResult result){
		itemservice.deleteitem(prepareItemModel(itembean));
		Map model=new HashMap();
		model.put("items",prepareListBean(itemservice.listitem()) );
		return new ModelAndView("adminpage",model);
	}
	@RequestMapping(value="adminlogout")
	public ModelAndView logout(){
		return new ModelAndView("adminlogout");
	}
	
	@RequestMapping(value="/women")
	public ModelAndView women(@ModelAttribute("command") CustomerBean customerbean,BindingResult result){
		Map model=new HashMap();
		model.put("customer",preparebean(customerservice.get((int)session.getAttribute("custid"))) );
		return new ModelAndView("women",model);
	}
	
	public Map method(String cat){
		List<ItemBean> l=prepareListBean(itemservice.listitem());
		List<ItemBean> n=null;
		if(l!=null && !(l.isEmpty())){
			Iterator i=l.iterator();
			ItemBean b=null;
			n= new ArrayList<ItemBean>();
		while(i.hasNext()){
			b=(ItemBean)i.next();
			if(b.getCatogory().equals(cat)){
				n.add(b);
			}
		}
		}
		Map model=new HashMap();
		model.put("dressitem", n);
		model.put("customer",preparebean(customerservice.get((int)session.getAttribute("custid"))));
		return model;
	}
	
	private String s;
	@RequestMapping("/*")
	public ModelAndView dress(@ModelAttribute("command") ItemBean itembean,BindingResult result,HttpServletRequest request){
		s=request.getParameter("cat");
		Map model=method(s);
		
		return new ModelAndView("women",model);
		
	}
	
	public Item prepareItemModel(ItemBean itembean){
		Item item=new Item();
		item.setItemid(itembean.getItemid());
		item.setCatogory(itembean.getCatogory());
		item.setDescription(itembean.getDescription());
		item.setPrice(itembean.getPrice());
		
		return item;
	}
	public ItemBean prepareItemBean(Item item){
		ItemBean itembean=new ItemBean();
		itembean.setItemid(item.getItemid());
		itembean.setCatogory(item.getCatogory());
		itembean.setDescription(item.getDescription());
		itembean.setPrice(item.getPrice());
		return itembean;
		
	}
	public List<ItemBean> prepareListBean(List<Item> item){
		List<ItemBean> beans=null;
		if(item!=null && !(item.isEmpty())){
			beans=new ArrayList<ItemBean>();
			ItemBean bean=null;
			for(Item t:item){
				bean=new ItemBean();
				bean.setItemid(t.getItemid());
				bean.setCatogory(t.getCatogory());
				bean.setDescription(t.getDescription());
				bean.setPrice(t.getPrice());
				beans.add(bean);
			}
				}
		return beans;
		
	}
	
	@RequestMapping(value="/addthisitem")
	public ModelAndView addthisitem(@ModelAttribute("command") PurchaseBean purchasebean,BindingResult result,HttpServletRequest request){
		Purchase purchase=new Purchase();
		purchase.setPid(purchasebean.getPid());
		purchase.setCid((Integer) session.getAttribute("custid"));
		purchase.setIid(Integer.parseInt(request.getParameter("itemid")));
		purchaseservice.addPurchase(purchase);
		Map model=method(s);
		return new ModelAndView("women",model);
	}
	
	public Map cartmethod(){
		List<PurchaseBean> b=preparebeanlist(purchaseservice.listPurchase());
		List<ItemBean> a=prepareListBean(itemservice.listitem());
		PurchaseBean b1=null;
		int cost=0;
		PurchaseItem q=null;
		List<PurchaseItem> q1=new ArrayList<PurchaseItem>();
		ItemBean b2=null;
		List<ItemBean> b3=new ArrayList<ItemBean>();
		List<PurchaseBean> p=new ArrayList<PurchaseBean>();
		if(a!=null && !(a.isEmpty())){
			if(b!=null && !(b.isEmpty())){
				Iterator i=b.iterator();
				while(i.hasNext()){
					b1=(PurchaseBean)i.next();
					
					if(b1.getCid().equals(session.getAttribute("custid"))){
						
						Iterator i1=a.iterator();
						while(i1.hasNext()){
							b2=(ItemBean)i1.next();
							if(b1.getIid().equals(b2.getItemid())){
								cost=cost+b2.getPrice();
								q=new PurchaseItem();
								q.setPid(b1.getPid());
								q.setItemid(b2.getItemid());
								q.setCatogory(b2.getCatogory());
								q.setDescription(b2.getDescription());
								q.setPrice(b2.getPrice());
								q1.add(q);
							}
						
						}
					}
				}
			}
		}
		
		Map model=new HashMap();
		model.put("purchaselist", q1);
		model.put("total", cost);
		model.put("customer", preparebean(customerservice.get( (Integer)session.getAttribute("custid"))));
		return model;
	}
	@RequestMapping(value="/cart")
	public ModelAndView displaycart(@ModelAttribute("command") PurchaseBean purchasebean,BindingResult result){
		Map model=cartmethod();
		return new ModelAndView("cartlist",model);
		
	}
	
	@RequestMapping(value="/remove")
	public ModelAndView remove(HttpServletRequest request){
		purchaseservice.deletePurchase(purchaseservice.getPurchase(Integer.parseInt(request.getParameter("pid"))));
		Map model=cartmethod();
		return new ModelAndView("cartlist",model);
	}
	
	
	
	public List<PurchaseBean> preparebeanlist(List<Purchase> purchase){
		List<PurchaseBean> beans=null;
		if(purchase!=null && !(purchase.isEmpty())){
			beans=new ArrayList<PurchaseBean>();
			PurchaseBean bean=null;
			for(Purchase p:purchase){
				bean=new PurchaseBean();
				bean.setPid(p.getPid());
				bean.setCid(p.getCid());
				bean.setIid(p.getIid());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	@RequestMapping(value="/checkout")
	public ModelAndView check(){
		Map model=new HashMap();
		model.put("customer", preparebean(customerservice.get( (Integer)session.getAttribute("custid"))));
		return new ModelAndView("checkout",model);
	}
	
}
