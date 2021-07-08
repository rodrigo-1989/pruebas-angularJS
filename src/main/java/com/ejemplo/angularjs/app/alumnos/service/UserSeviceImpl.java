package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.angularjs.app.alumnos.models.dao.UserRepository;
import com.ejemplo.angularjs.app.alumnos.models.entity.User;

@Service
public class UserSeviceImpl implements IUserService {
	
	@Autowired
	private UserRepository clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		User usuario = new User();
		usuario.setNombre("Error, usuario/contraseña incorectos");
		usuario.setContrasena("../fac/");
		return clienteDao.findById(id).orElse(usuario);
	}

	@Override
	@Transactional
	public User save(User user) {
		return clienteDao.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteDao.deleteById(id);;
	}

	@Override
	public User findByIdAndContrasena(String codigo, String contrasena) {
		return clienteDao.findByCodigoAndContrasena(codigo, contrasena);
	}



}
