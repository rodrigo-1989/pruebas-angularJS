package com.ejemplo.angularjs.app.alumnos.dto;

import java.util.Date;

public class RegistrosExcel {
	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private int edad;
	
	private String sexo;

	private Date fechaInicio;

	public RegistrosExcel() {}

	public RegistrosExcel(Long id,String nombre,String apellido, int edad, String sexo, Date fechaInicio) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		return "RegistrosExcel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", sexo=" + sexo + ", fechaInicio=" + fechaInicio + "]";
	}

	
}
