package com.ejemplo.angularjs.app.alumnos.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

@Service
public interface IPaisDaoJdbc {
	
	public List<Pais> listarTodos();
	

}
