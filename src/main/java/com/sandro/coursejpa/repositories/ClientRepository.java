package com.sandro.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandro.coursejpa.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
