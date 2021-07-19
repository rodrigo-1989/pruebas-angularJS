package com.ejemplo.angularjs.app.alumnos.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.angularjs.app.alumnos.models.dao.AlumnoRepository;
import com.ejemplo.angularjs.app.alumnos.models.entity.Alumno;
import com.jcraft.jsch.*;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private AlumnoRepository alumnoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Long id) {
		return alumnoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return alumnoDao.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		alumnoDao.deleteById(id);
	}

	@Override
	public void guardarAlumnos() {
		List<Alumno> lista = (List<Alumno>) alumnoDao.findAll();
		try {
			PrintWriter archivo = new PrintWriter("/Users/rodrigo/Desktop/archivo.txt", "UTF-8");
			lista.forEach(alumno -> {
				archivo.println(alumno.toString());
			});

			archivo.close();
			
			
			try {
				JSch jsch = new JSch();
				Session session = jsch.getSession("pi","192.168.0.5",22);
				session.setPassword("roch");

				session.setConfig("StrictHostKeyChecking", "no");
				session.connect();
				
				Channel channel = session.openChannel("sftp");
				channel.connect();
				
				ChannelSftp sftp = (ChannelSftp) channel;
				
				sftp.put("/Users/rodrigo/Desktop/archivo.txt","/home/pi/documentos/clientes.txt");
				
				channel.disconnect();
				session.disconnect();
				
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}


		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
