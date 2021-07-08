package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.angularjs.app.alumnos.models.entity.Cliente;
import com.ejemplo.angularjs.app.alumnos.service.IClienteService;

@RestController
@CrossOrigin( origins ="*" )
@RequestMapping({"/clientes"})
public class Clientecontroller {

	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	@GetMapping("/listarPag/{page}/{pageSize}")
	public Page<Cliente> listarDiez(@PathVariable int page,@PathVariable int pageSize){
		Pageable pages = PageRequest.of(page, pageSize);
		return clienteService.findAll(pages);
	}
	
	@GetMapping("/listar/{id}")
	public Cliente ver(@PathVariable Long id){
		return clienteService.findById(id);
	} 
	
	
	@PostMapping("/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente editar(@RequestBody Cliente cliente) {
		
		if (cliente.getId()!=null) {
			Cliente clienteDb = clienteService.findById(cliente.getId());
			clienteDb.setNombre(cliente.getNombre());
			clienteDb.setCorreo(cliente.getCorreo());
			clienteDb.setZip(cliente.getZip());
			clienteDb.setTelefono1(cliente.getTelefono1());
			clienteDb.setTelefono2(cliente.getTelefono2());
			clienteDb.setPais(cliente.getPais());
			clienteDb.setDireccion(cliente.getDireccion());
			
			return clienteService.save(clienteDb);
		}
		
		return clienteService.save(cliente);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
	
	
}
