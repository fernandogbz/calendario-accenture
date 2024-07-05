package com.javiersalinas.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity // Esto le dice al código que lo siguiente será una entidad
@Table(name = "usuarios") // Se refiere a qué tabla de la base de datos se estudiará

public class Usuario {
	@Id // Significa que es la primary KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Será autogenerada
	private Long id;
	
	@Size(min=2, message ="Por favor proporciona tu nombre.") // MINIMO DE CARACTERES
	private String nombre;
	
	@Size(min=2, message ="Por favor proporcionar tu apellido.") // MINIMO DE CARACTERES
	private String apellido;
	
	@Email(message = "Por favor proporciona un correo válido.")
	private String correo;
	
	private String contraseña;
	
	@Transient
	private String confirmarContraseña;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;
	
	public Usuario() {}
	
	@PrePersist // Cuando el objeto se crea tomará la fecha actual
	protected void onCreate() {
		this.fechaCreacion = new Date(); // Le da esto a la fecha de creacion
		this.fechaActualizacion = this.fechaCreacion; // Luego  la de actualización le da la misma (pues en primera instancia coinciden)
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getConfirmarContraseña() {
		return confirmarContraseña;
	}

	public void setConfirmarContraseña(String confirmarContraseña) {
		this.confirmarContraseña = confirmarContraseña;
	}

	

	
	
}

