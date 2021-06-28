package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

@Service
public class PaisServiceImplJdbc implements IPaisServiceJdbc {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pais> listarTodos(){
        return jdbcTemplate.query("select * from paises",
                new BeanPropertyRowMapper<>(Pais.class));
    }
	


}
