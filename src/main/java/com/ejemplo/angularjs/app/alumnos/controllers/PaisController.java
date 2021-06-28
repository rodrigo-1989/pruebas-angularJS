package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;
import com.ejemplo.angularjs.app.alumnos.service.IPaisService;

@RestController
@CrossOrigin( origins ="*" )
@RequestMapping({"/pais"})
public class PaisController {

	@Autowired
	private IPaisService paisService;
	
	
	@GetMapping("/listar")
	public List<Pais> listar(){
		return paisService.findAll();
	}
	
	@GetMapping("/listardiez")
	public Page<Pais> listarDiez(@PageableDefault (size = 10, page = 0) Pageable pageable){
		return paisService.findTen(pageable);
	}
	
	@GetMapping("/listar/{id}")
	public Pais ver(@PathVariable Long id){
		return paisService.findById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Pais crear(@RequestBody Pais pais) {
		return paisService.save(pais);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Pais editar(@RequestBody Pais pais,@PathVariable Long id) {
		Pais paisDb = paisService.findById(id);
		paisDb.setIso(pais.getIso());
		paisDb.setNombre(pais.getNombre());
		
		return paisService.save(paisDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		paisService.deleteById(id);
	}
	
	
}
