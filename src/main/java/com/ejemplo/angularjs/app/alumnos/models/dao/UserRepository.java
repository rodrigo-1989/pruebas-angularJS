package com.ejemplo.angularjs.app.alumnos.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.ejemplo.angularjs.app.alumnos.models.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	@Query(value = "select * from users where codigo =?1  AND contrasena =?2", nativeQuery = true)
	  User findByCodigoAndContrasena(String codigo,String contrasena);
}
