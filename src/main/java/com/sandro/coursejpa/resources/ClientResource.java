package com.sandro.coursejpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.coursejpa.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	
	@GetMapping
	public ResponseEntity<Client> findAll(){
		Client c = new Client(null, "Eduardo", "eduardo@mail.com", "999999999", "12345" );
		
		return ResponseEntity.ok().body(c);
		
		
		
	}

}
