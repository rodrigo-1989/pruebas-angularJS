package com.ejemplo.angularjs.app.alumnos.dto;

public class RegistrosExcel {
	
	private String nombre;
	
	private Double edad;
	
	private String sexo;

	public RegistrosExcel() {}

	public RegistrosExcel(String nombre, Double edad, String sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "RegistrosExcel [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + "]";
	}
	
}
