package com.desafio3.desafio3.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	List<Client> findByName(String string);
	
	List<Client> findByNameAndSurname(String name, String surname);
	
}
