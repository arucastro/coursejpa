package com.sandro.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sandro.coursejpa.entities.Client;
import com.sandro.coursejpa.repositories.ClientRepository;
import com.sandro.coursejpa.services.exceptions.DatabaseException;
import com.sandro.coursejpa.services.exceptions.ResourceNotFoundException;


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
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
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
