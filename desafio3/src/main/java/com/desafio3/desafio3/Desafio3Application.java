package com.desafio3.desafio3;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import com.desafio3.desafio3.model.Client;
import com.desafio3.desafio3.model.ClientRepository;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner{
	
	@Autowired
	private ClientRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		//Creación de atributos
		System.err.println("Creación atributos");
		Client newClient = new Client();
		Client newClient1 = new Client();
		Client newClient2 = new Client();
		List<Client> client = new ArrayList<>();

		//Creación de nuestra BBDD con datos
		System.err.println("Creación de BBDD");		
		newClient.setDni("12345678A");
		newClient.setName("Adrian");
		newClient.setSurname("Gomez");
		newClient.setFechaNacimmiento(new GregorianCalendar(1985,4,6));
		client.add(newClient);
		
		newClient1.setDni("22345678A");
		newClient1.setName("Maria");
		newClient1.setSurname("Perez");
		newClient1.setFechaNacimmiento(new GregorianCalendar(1987,11,26));
		client.add(newClient1);
		
		newClient2.setDni("32345678A");
		newClient2.setName("Juan");
		newClient2.setSurname("Garcia");
		newClient2.setFechaNacimmiento(new GregorianCalendar(1995,5,16));
		client.add(newClient2);
		
		for (Client client2 : client) {
			System.err.println(client2.toString());
		}
		
		//Creación del repositorio		
		System.err.println("Creación de BBDD - repository");		
		repository.saveAll(client);
		
		//Agregar solo 1 más
		Client newClient4 = new Client();
		newClient4.setDni("52345678A");
		newClient4.setName("Monica");
		newClient4.setSurname("Casas");
		newClient4.setFechaNacimmiento(new GregorianCalendar(2001,2,6));
		client.add(newClient4);
		repository.save(newClient4);
		
		//Update
		newClient4.setSurname("Gonzalez");
		repository.saveAndFlush(newClient4);
		
		//Búsqueda
		System.err.println("Búsqueda");
		List<Client> lista = repository.findByName("Monica");
		if(!CollectionUtils.isEmpty(lista)) {
			System.err.println(lista.get(0).toString());
		}
		
		List<Client> lista2 = repository.findByNameAndSurname("Monica","Gonzalez");
		if(!CollectionUtils.isEmpty(lista)) {
			System.err.println(lista.get(0).toString());
		}
		
		//Delete
		repository.delete(newClient4);
		
		
	}

}
