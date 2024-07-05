package com.accenture.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	nombre apellido correo rol user password Tribo
	
	En tabla de eventos:
		
		- nombre descripcion duracion fecha y hora, modalidad (presencial o virtual) responsable wbs(costo), facilitador (speeker o el que lo imparte), link de acceso, lugar (opcional), 
}
