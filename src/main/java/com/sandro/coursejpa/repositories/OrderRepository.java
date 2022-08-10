package com.sandro.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandro.coursejpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
