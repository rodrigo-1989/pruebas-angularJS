package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejemplo.angularjs.app.alumnos.models.entity.Pais;
import com.ejemplo.angularjs.app.alumnos.service.IPaisServiceJdbc;

@Controller
@CrossOrigin( origins ="*" )
public class JdbcController {
	
	@Autowired
	private IPaisServiceJdbc paisJdbc;
	
    @RequestMapping(value = {"/pais/jdbcs"},method = RequestMethod.GET)
    @ResponseBody
    public List<Pais> getUsers(){
        return paisJdbc.listarTodos();
    }

}
