package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.angularjs.app.alumnos.models.dao.PaisRepository;
import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

@Service
public class PaisServiceImpl implements IPaisService {
	
	@Autowired
	private PaisRepository paisDao;

	@Override
	@Transactional(readOnly = true)
	public List<Pais> findAll() {
		return (List<Pais>) paisDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pais findById(Long id) {
		return paisDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pais save(Pais pais) {
		return paisDao.save(pais);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		paisDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pais> findTen(Pageable pageable) {
		return paisDao.findAll(pageable);
	}

}
