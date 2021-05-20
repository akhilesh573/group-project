package com.finalproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.grocery.entity.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> 
{

}
