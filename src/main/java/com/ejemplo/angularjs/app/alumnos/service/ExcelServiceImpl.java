package com.ejemplo.angularjs.app.alumnos.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.angularjs.app.alumnos.dto.RegistrosExcel;
import com.ejemplo.angularjs.app.alumnos.models.dao.ExcelRepository;
import com.ejemplo.angularjs.app.alumnos.models.entity.RegistrosExcelBean;

@Service
public class ExcelServiceImpl implements IExcelService{
	
	@Autowired
	private ExcelRepository excelRepository;
	
	private static String FORMATO_FECHA ="MM/dd/yyyy";
	SimpleDateFormat FECHA = new SimpleDateFormat(FORMATO_FECHA, Locale.US);
	
	@Override
	public List<RegistrosExcel> respuesta(MultipartFile file) {
	    Integer alumnos = 0;
	    RegistrosExcelBean registroBean = null;
	    List<RegistrosExcel> lista = new ArrayList<>();
		RegistrosExcel registro = null;
		
	    InputStream reader = null;
	    Workbook lector = null;
	    
	    try {
	    	File fileToUse  = convertFile(file);
	    	reader = new FileInputStream(fileToUse);
	    	lector = WorkbookFactory.create(reader);
	    	Sheet hojaActual = lector.getSheetAt(0);
	    	Iterator<Row> iterator =  hojaActual.rowIterator();
	    	Row fila= hojaActual.getRow(1);
	    	
	    	while(iterator.hasNext()) {
	    		fila = iterator.next();
	    		
	    		if(fila.getRowNum()>0) {
	    			registro = new RegistrosExcel();
		    		registro.setNombre(hojaActual.getRow(fila.getRowNum()).getCell(0).getStringCellValue());
					registro.setEdad((int)hojaActual.getRow(fila.getRowNum()).getCell(1).getNumericCellValue());
					registro.setSexo(hojaActual.getRow(fila.getRowNum()).getCell(2).getStringCellValue());
					registro.setFechaInicio(getDateFormat(getValidateDate(hojaActual.getRow(fila.getRowNum()).getCell(3).getStringCellValue())));
					lista.add( registro);
					
					registroBean = new RegistrosExcelBean(
							registro.getId(),
							registro.getNombre(),
							registro.getEdad(),
							registro.getSexo(),
							registro.getFechaInicio()
							);
					alumnos = validaRegistroAGuardar(registroBean,alumnos);
					
	    		}
	    	}
	    	
		} catch (Exception e) {
			System.out.println("Algo fallo "+e.getMessage());
		}
	    
		System.out.println("Se guardaron " +alumnos + " Registros");
		return lista;
	}
	
	private Integer validaRegistroAGuardar(RegistrosExcelBean registroBean, int alumno) { 
		List<String> diferencias = new ArrayList<>();
		if(existeRegistro(registroBean.getNombre(),registroBean.getFechaInicio())){
			
			RegistrosExcelBean registro= getRegistroExixtente(registroBean.getNombre(),registroBean.getFechaInicio());
			
			if(registro.getEdad() != registroBean.getEdad()) {				
				registro.setEdad(registroBean.getEdad());
				diferencias.add("El registro de "+registroBean.getNombre()+" cabio en la edad");
			}
			if(!registro.getSexo().equals(registroBean.getSexo())  ) {
				registro.setSexo(registroBean.getSexo());
				diferencias.add(" cabio en el sexo");
			}
			if(!diferencias.isEmpty()) {
				excelRepository.save(registro);
			}
			
			for (String val:diferencias ) {
				System.out.print(val);
			}
			System.out.println();
		}else
		{
			guardar(registroBean);
			
			alumno++;	
		}
		return alumno;
	}

	private boolean existeRegistro(String nombre, Date fecha) {
		RegistrosExcelBean registro = null;
		registro = excelRepository.findByNombreAndDate(nombre,fecha);
		return registro != null;
	}
	
	private RegistrosExcelBean getRegistroExixtente(String nombre, Date fecha) {
		RegistrosExcelBean registro = null;
		registro = excelRepository.findByNombreAndDate(nombre,fecha);
		return (registro != null)? registro: new RegistrosExcelBean();
	}
	
	private Date getDateFormat(String fechaToConvert) {
		Date d = null;
		Calendar cal = null;
		try {
			d = FECHA.parse(fechaToConvert);
			cal = Calendar.getInstance();
			cal.setTime(d);
		} catch (ParseException e) {
			
			System.out.println("Error en el metodo getDateFormat" + fechaToConvert);
		}
		
		return cal.getTime();
	}
	
	private String getValidateDate(String fecha) {
		return fecha.replace("-", "/");
	}
	
	private void guardar(RegistrosExcelBean registro) {
		System.out.println("Se guardo el alumno => " + registro.toString()+ "con exito!!");
		excelRepository.save(registro);
	}
	
	@Override
	public RegistrosExcelBean findByNombreAndDate(String nombre, String fecha) {
		RegistrosExcelBean registro = null;
		System.out.println("Fecha para hacer la consulta =>"+getDateFormat(getValidateDate(fecha)));
			registro = excelRepository.findByNombreAndDate(nombre,getDateFormat(getValidateDate(fecha)));
		return registro;
	}
	
	private File convertFile(MultipartFile file) throws IOException{
		
		File getFile = new File(file.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(getFile);
		stream.write(file.getBytes());
		stream.close();
		return getFile;
	}

}


//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//String fechaComoCadena = sdf.format(registro.getFechaInicio());
//System.out.println("fecha en reverso => " + fechaComoCadena +" Fecha sin reverso "+ new Date() );