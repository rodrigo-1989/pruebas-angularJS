package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.Date;
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

import com.ejemplo.angularjs.app.alumnos.models.entity.User;
import com.ejemplo.angularjs.app.alumnos.service.IUserService;

@RestController
@CrossOrigin( origins ="*" )
@RequestMapping({"/user"})
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	@GetMapping("/listar")
	public List<User> listar(){
		return userService.findAll();
	}
	
	@GetMapping("/listarPag/{page}/{pageSize}")
	public Page<User> listarDiez(@PathVariable int page,@PathVariable int pageSize){
		Pageable pages = PageRequest.of(page, pageSize);
		return userService.findAll(pages);
	}
	
	@GetMapping("/listar/{id}")
	public User ver(@PathVariable Long id){
		return userService.findById(id);
	} 
	
	@PostMapping("/buscar")
	public User ver(@RequestBody User usuario){
		
		java.util.Date fecha = new Date();
		User user = userService.findByIdAndContrasena(usuario.getCodigo(), usuario.getContrasena());

		user.setUltimoacceso(fecha);
		userService.save(user);
		
		return userService.findById(user.getId());
	} 
	
	
	@PostMapping("/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public User editar(@RequestBody User user) {
		
		if (user.getId()!=null) {
			User userDb = userService.findById(user.getId());
			userDb.setNombre(user.getNombre());
			userDb.setCodigo(user.getCodigo());
			userDb.setContrasena(user.getContrasena());
			
			return userService.save(userDb);
		}
		
		return userService.save(user);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		userService.deleteById(id);
	}
	
	
}
