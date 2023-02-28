package com.example.demo.paralelo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.paralelo.modelo.Ciudadano;
import com.example.demo.paralelo.modelo.Estudiante;
import com.example.demo.paralelo.repo.ICiudadanoRepo;
import com.example.demo.paralelo.repo.IEstudianteRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public List<Ciudadano> consultarTodos() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepo.ObtenerCiudadanos();
	}

	@Override
	public void convertir(Ciudadano ciu) {
		// TODO Auto-generated method stub
		Estudiante estu = new Estudiante();
		estu.setNombreCompleto(ciu.getNombre()+" "+ciu.getApellido());
		int edad=LocalDateTime.now().getYear() - ciu.getFechaNacimiento().getYear(); 
		estu.setEdad(edad);
		this.estudianteRepo.insertar(estu);
	}

}
