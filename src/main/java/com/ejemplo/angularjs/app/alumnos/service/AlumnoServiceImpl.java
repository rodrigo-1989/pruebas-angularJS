package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.angularjs.app.alumnos.models.dao.AlumnoRepository;
import com.ejemplo.angularjs.app.alumnos.models.entity.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Long id) {
		return alumnoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return alumnoDao.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		alumnoDao.deleteById(id);
	}

}
