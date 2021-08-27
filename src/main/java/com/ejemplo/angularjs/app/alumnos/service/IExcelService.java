package com.ejemplo.angularjs.app.alumnos.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.angularjs.app.alumnos.dto.RegistrosExcel;

public interface IExcelService {
	
	public List<RegistrosExcel> respuesta(MultipartFile file);

}
