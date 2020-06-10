package com.ompcweb.tiendaRocio.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "articulos" )
public class Articulo implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String leyenda;
	private String descripcion;
	@NotNull
	private double precio;
	private double oferta;
	@NotEmpty
	private String imagenes;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@NotNull
	private int stock;
	private String links;
	@NotEmpty
	private String hashtags;
	
	@PrePersist
	public void prePersist() {
		fecha= new Date();
	}
	
}
