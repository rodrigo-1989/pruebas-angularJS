package com.ejemplo.angularjs.app.alumnos.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ejemplo.angularjs.app.alumnos.models.entity.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

}
