package com.ejemplo.angularjs.app.alumnos.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regisrtos_excel")
public class RegistrosExcelBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private int edad;
	
	private String sexo;
	
	@Column(name ="fecha_inicio")
	private Date fechaInicio;

	public RegistrosExcelBean() {}

	public RegistrosExcelBean(Long id,String nombre, int edad, String sexo, Date fechaInicio) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.fechaInicio = fechaInicio;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public String toString() {
		return "RegistrosExcelBean [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo
				+ ", fechaInicio=" + fechaInicio + "]";
	}

	
}
