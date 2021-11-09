package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.OrderNotFoundException;
import com.entites.BooksIssued;
import com.entites.BooksOrder;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
@Service
public class BooksOrderServImp implements BooksOrderServ{

	 @Autowired
	 BooksOrderRepository rep;
	 @Autowired
	 BooksRepository repo;
	  @Override
	public BooksOrder placeBooksOrder(BooksOrder orderdetails) 
	{
		return rep.save(orderdetails);
	   
	}

	@Override
	public String cancelOrder(BooksOrder orderId) 
	{
		rep.delete(orderId);
		return "Order Cancelled";
	}

	@Override
	public BooksOrder updateOrder(BooksOrder order) throws Throwable {
		int orderid = order.getOrderId();
		Supplier s2 = ()-> new OrderNotFoundException("Order not Found");
		BooksOrder bo=rep.findById(orderid).orElseThrow(s2);
	     bo.setBooks(order.getBooks());
		bo.setQuantity(order.getQuantity());
		bo.setOrderDate(order.getOrderDate());
		bo.setOrderStatus(order.getOrderStatus());
		rep.save(bo);		
		return bo;
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		List<BooksOrder> lbo = rep.findAll();
		return lbo;
	}

	@Override
	public BooksOrder viewOrderById(int orderId) throws Throwable {
	//	int orderid=orderId.getOrderId();
		Supplier s2 = ()-> new OrderNotFoundException("Order not Found");
		BooksOrder bo1 = rep.findById(orderId).orElseThrow(s2);
		return bo1;
	}
	@Override
	public  BooksOrder findByOrderId(int orderId) 
	 {
		Supplier s2 = ()-> new OrderNotFoundException("Order not Found");
		BooksOrder c1=rep.findByOrderId(orderId);//.orElseThrow(s2);
		return c1;
	 }
      @Override

	public  List<BooksOrder> findByOrderStatus(String orderStatus)
	 {
	 List<BooksOrder> lc=rep.findByOrderStatus(orderStatus);
	  return lc;
	
	 }
}
