package com.sandro.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandro.coursejpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
