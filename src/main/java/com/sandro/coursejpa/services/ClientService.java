package com.sandro.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandro.coursejpa.entities.Client;
import com.sandro.coursejpa.repositories.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll (){
		return repository.findAll();
	}
	
	
	public Client findById (Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
}
