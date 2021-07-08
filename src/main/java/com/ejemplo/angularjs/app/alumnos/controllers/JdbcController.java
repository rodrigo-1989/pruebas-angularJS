package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejemplo.angularjs.app.alumnos.dao.IPaisDaoJdbc;
import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;

@Controller
@CrossOrigin( origins ="*" )
public class JdbcController {
	
	@Autowired
	private IPaisDaoJdbc paisJdbc;
	
	@Autowired
	private JdbcTemplate template;
	
	String query = "SELECT * FROM paises";
	String query1 = "select nombre from paises where iso = 'MX';";
	
    @RequestMapping(value = {"/pais/jdbcs"},method = RequestMethod.GET)
    @ResponseBody
    public List<Pais> getUsers(){
        return paisJdbc.listarTodos();
    }
    
    @RequestMapping(value = {"/pais/listajdbc"},method = RequestMethod.GET)
    @ResponseBody
    public List<Pais> milista(){
        return template.query(query,new BeanPropertyRowMapper<>(Pais.class));
    }
    
    @RequestMapping(value = {"/pais/uno"},method = RequestMethod.GET)
    @ResponseBody
    public String uno(){
    	Map<String, Object> resultado = template.queryForMap(query1);
    	
        return resultado.toString();
    }

}
