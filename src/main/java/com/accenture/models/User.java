package com.accenture.models;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, message ="Por favor proporciona tu nombre.") // MINIMO DE CARACTERES
	private String name;
	
	@Size(min=2, message ="Por favor proporcionar tu apellido.") // MINIMO DE CARACTERES
	private String lastName;
	
	@Email(message = "Por favor proporciona un correo válido.")
	private String mail;
	
	@Size(min = 5, message = "Por favor proporcione un nombre de usuario válido.") // MINIMO DE CARACTERES
	private String username;
	
	@Size(min=8, message="Por favor proporcione una contraseña de almenos 8 caractéres.") // MÍNIMO DE CARACTERES
	private String password;

	private String role;
	
	private String tribo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;
	
	public User() {}
	
	@PrePersist // Cuando el objeto se crea tomará la fecha actual
	protected void onCreate() {
		this.createDate = new Date(); // Le da esto a la fecha de creacion
		this.updateDate = this.createDate; // Luego  la de actualización le da la misma (pues en primera instancia coinciden)
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTribo() {
		return tribo;
	}

	public void setTribo(String tribo) {
		this.tribo = tribo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
