package com.sandro.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandro.coursejpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
