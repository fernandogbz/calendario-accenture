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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, message ="Por favor proporciona tu nombre.") // MINIMO DE CARACTERES
	private String name;
	
	@Size(max=200, message = "Máximo de 200 caracteres excedido.")
	private String duration;
	
	private String date; // Fecha
	
	private String dateTime; // Hora
	
	private String modality; // Presencial o virtual
	
	private String responsable;
	
	private Long capacity;
	
	private Double cost; // Costo
	
	private String facilitator; // Speeker o quien imparte
	
	private String accessLink; // Link de acceso
	
	private String place; // Lugar (opcional)
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;
	
	public Event() {}
	
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getFacilitator() {
		return facilitator;
	}

	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	public String getAccessLink() {
		return accessLink;
	}

	public void setAccessLink(String accessLink) {
		this.accessLink = accessLink;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
}
