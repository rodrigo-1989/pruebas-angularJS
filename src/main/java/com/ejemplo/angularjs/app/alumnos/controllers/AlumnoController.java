package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.angularjs.app.alumnos.models.entity.Alumno;
import com.ejemplo.angularjs.app.alumnos.service.IAlumnoService;

@RestController
@CrossOrigin( origins ="*" )
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	
	@GetMapping("/listar")
	public List<Alumno> listar(){
		return alumnoService.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Alumno ver(@PathVariable Long id){
		return alumnoService.findById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno crear(@RequestBody Alumno alumno) {
		return alumnoService.save(alumno);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno editar(@RequestBody Alumno alumno,@PathVariable Long id) {
		Alumno alumnoDb = alumnoService.findById(id);
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setTelefono(alumno.getTelefono());
		alumnoDb.setDireccion(alumno.getDireccion());
		
		return alumnoService.save(alumnoDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		alumnoService.deleteById(id);
	}
	
	
}
