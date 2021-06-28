package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

public interface IPaisService {
	
	public List<Pais> findAll();
	
	public Page<Pais> findTen(Pageable pageable);
	
	public Pais findById(Long id);
	
	public Pais save(Pais pais);
	
	public void deleteById(Long id);

}
