package com.desafio3.desafio3.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String dni;
	
	private Calendar fechaNacimmiento;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name= "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name= "SURNAME", nullable = false)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name= "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name= "FECHANACIMIENTO")
	public Calendar getFechaNacimmiento() {
		return fechaNacimmiento;
	}

	public void setFechaNacimmiento(Calendar fechaNacimmiento) {
		this.fechaNacimmiento = fechaNacimmiento;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", dni=" + dni + ", fechaNacimmiento="
				+ fechaNacimmiento.get(Calendar.YEAR)+ "/" + fechaNacimmiento.get(Calendar.MONTH) + "/" + fechaNacimmiento.get(Calendar.DAY_OF_MONTH) + "]";
	}

	
	
	
}
