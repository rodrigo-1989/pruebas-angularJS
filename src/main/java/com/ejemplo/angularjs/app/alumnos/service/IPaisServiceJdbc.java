package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

@Service
public interface IPaisServiceJdbc {
	
	public List<Pais> listarTodos();
	
	//public Pais findById(Long id);
	
	//public Pais save(Pais pais);
	
	//public void deleteById(Long id);

}
