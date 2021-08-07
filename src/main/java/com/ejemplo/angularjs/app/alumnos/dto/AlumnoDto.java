package com.ejemplo.angularjs.app.alumnos.dto;

import java.io.Serializable;

public class AlumnoDto implements Serializable{

	private Long codigo;
	
	private String nombre;
	
	private String telefono;
	
	private String direccion;
	



	public AlumnoDto() {}
	public AlumnoDto(Long codigo, String nombre, String telefono, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", pais=" + "]";
	}





	private static final long serialVersionUID = -1285161595725274652L;
}
