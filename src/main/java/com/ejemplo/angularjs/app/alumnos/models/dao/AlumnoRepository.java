package com.ejemplo.angularjs.app.alumnos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ejemplo.angularjs.app.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long>{

}
