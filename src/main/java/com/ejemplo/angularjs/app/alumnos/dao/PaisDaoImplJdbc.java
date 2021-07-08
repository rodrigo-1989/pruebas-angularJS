package com.ejemplo.angularjs.app.alumnos.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;
import com.ejemplo.angularjs.app.alumnos.service.IPaisServiceJdbc;

@Service
public class PaisDaoImplJdbc implements IPaisDaoJdbc {

	private IPaisServiceJdbc service;

    public List<Pais> listarTodos(){
        return service.listarTodos();
    }
	


}
