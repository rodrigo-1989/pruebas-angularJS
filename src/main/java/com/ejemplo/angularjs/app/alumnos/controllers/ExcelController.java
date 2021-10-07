package com.ejemplo.angularjs.app.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.angularjs.app.alumnos.dto.RegistrosExcel;
import com.ejemplo.angularjs.app.alumnos.models.entity.RegistrosExcelBean;
import com.ejemplo.angularjs.app.alumnos.service.IExcelService;

@RestController
@CrossOrigin( origins ="*" )
@RequestMapping({"/excel"})
public class ExcelController {
	
	@Autowired
	private IExcelService excelService;
	
	@RequestMapping( value = "/cargarAlumnos", method = {RequestMethod.POST})
	public @ResponseBody List<RegistrosExcel> cargarAluumnos( @RequestParam ("fileInput") MultipartFile file) {
		return excelService.respuesta(file);
	}
	
	@RequestMapping( value = "/listar/{nombre}/{fecha}", method = {RequestMethod.POST})
	public @ResponseBody RegistrosExcelBean listar(@PathVariable String nombre,@PathVariable String fecha ) {
		return excelService.findByNombreAndDate(nombre,fecha);
	}
	
	
}
