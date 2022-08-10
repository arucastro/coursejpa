package com.sandro.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandro.coursejpa.entities.Category;
import com.sandro.coursejpa.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll (){
		return repository.findAll();
	}
	
	
	public Category findById (Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
