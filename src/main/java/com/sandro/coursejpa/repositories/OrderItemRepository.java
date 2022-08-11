package com.sandro.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandro.coursejpa.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
