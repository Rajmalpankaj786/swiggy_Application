package com.swiggy.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swiggy.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
