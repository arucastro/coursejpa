package com.sandro.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandro.coursejpa.entities.Client;
import com.sandro.coursejpa.repositories.ClientRepository;
import com.sandro.coursejpa.resources.exceptions.ResourceNotFoundException;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll (){
		return repository.findAll();
	}
	
	
	public Client findById (Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Client update(Long id, Client obj) {
		Client entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}


	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
