package com.ejemplo.angularjs.app.alumnos.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

public interface PaisRepository extends PagingAndSortingRepository<Pais, Long>{

}
