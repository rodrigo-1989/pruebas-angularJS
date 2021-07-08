package com.ejemplo.angularjs.app.alumnos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	private String nombre;
	
	private String contrasena;
	
	private Date ultimoacceso;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Date getUltimoacceso() {
		return ultimoacceso;
	}

	public void setUltimoacceso(Date ultimoacceso) {
		this.ultimoacceso = ultimoacceso;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285161595725274652L;
}
