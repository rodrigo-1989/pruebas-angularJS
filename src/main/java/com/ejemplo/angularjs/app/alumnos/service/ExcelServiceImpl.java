package com.ejemplo.angularjs.app.alumnos.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.angularjs.app.alumnos.dto.RegistrosExcel;

@Service
public class ExcelServiceImpl implements IExcelService{

	@Override
	public List<RegistrosExcel> respuesta(MultipartFile file)  {
		
		
		List<RegistrosExcel> lista = new ArrayList<>();
		
		RegistrosExcel registro = null;
		
		File archivo = null;
		Workbook libroExcel = null;
		try {
			 archivo = new File("/Users/rodrigo/Documents/prueva.xlsx");
			 libroExcel = WorkbookFactory.create(new FileInputStream(archivo));
			 
			Sheet hojaActual = libroExcel.getSheetAt(0); //acceder a la primera hoja
			
			Row filaActual = null; //acceder a la primera fila en la hoja
			Cell celdaActual = null; //acceder a la primera celda en la fila

//			Iterator<Row> rows = hojaActual.rowIterator();
//			int i=1;
			for(int i =1; i<5;i++)
//			while (rows.hasNext())
			{
				registro = new RegistrosExcel();
				
				filaActual = hojaActual.getRow(i);

			    
			    //Iterator<Cell> cells = filaActual.cellIterator();
			    for(int j =0; j<3;j++)
//			    while (cells.hasNext())
			    {
			        celdaActual= filaActual.getCell(j);

			        System.out.println("Tipo dato: "+celdaActual.getCellType());
					if (celdaActual.getCellType() == CellType.STRING)
			        {
						String val = celdaActual.getStringCellValue();
						if(celdaActual.getColumnIndex() == 0) {
				            System.out.print(" Nombre: "+val);
				            registro.setNombre(val);
						}else {
				            System.out.print(" Sexo: "+val);
				            registro.setSexo(val);
						}

			        }
			        if(celdaActual.getCellType() == CellType.NUMERIC)
			        {
			        	double val = celdaActual.getNumericCellValue();
			            System.out.print(" Int: "+ val );
			            registro.setEdad(val);
			        }

			    }
//			    i++;
			    System.out.println();
			    lista.add(registro);

			}
		}catch (Exception e) {
			System.out.print("°_° problemas "+e);
		}finally {
			try {
				libroExcel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
			
	}

}
