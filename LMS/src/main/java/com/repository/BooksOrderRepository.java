package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.entites.BooksOrder;

public interface BooksOrderRepository extends JpaRepository<BooksOrder,Integer>{
	 @Query("Select orderId from BooksOrder bookid order by bookid.orderId")
	 BooksOrder findByOrderId(int orderId);// throws Throwable;
	
	 @Query("Select orderStatus from BooksOrder orderStatus order by orderStatus.orderStatus")
	 List<BooksOrder> findByOrderStatus(String orderStatus);
	 //@Query("Select orderStatus from BooksOrder orderId order by orderId.orderStatus")
}
