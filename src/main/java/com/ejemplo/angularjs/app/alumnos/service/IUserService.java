package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ejemplo.angularjs.app.alumnos.models.entity.User;

@Service
public interface IUserService {
	
	public List<User> findAll();
	
	public Page<User>findAll(Pageable pageable);
	
	public User findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
	
	public User findByIdAndContrasena(String codigo, String contrasena);


}
