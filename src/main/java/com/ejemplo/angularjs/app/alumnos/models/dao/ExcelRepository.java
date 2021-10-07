package com.ejemplo.angularjs.app.alumnos.models.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ejemplo.angularjs.app.alumnos.models.entity.RegistrosExcelBean;

public interface ExcelRepository extends CrudRepository<RegistrosExcelBean, Long> {
	
	@Query(value = "SELECT * FROM regisrtos_excel where nombre = ?1 AND fecha_inicio = ?2",nativeQuery = true)
	public RegistrosExcelBean findByNombreAndDate(String nombre,Date fecha);

}
