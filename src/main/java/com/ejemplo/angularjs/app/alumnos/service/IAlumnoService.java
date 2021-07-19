package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import com.ejemplo.angularjs.app.alumnos.models.entity.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> findAll();
	
	public Alumno findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(Long id);
	
	public void guardarAlumnos();

}
