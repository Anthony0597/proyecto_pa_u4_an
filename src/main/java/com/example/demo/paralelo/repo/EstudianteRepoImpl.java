package com.example.demo.paralelo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.paralelo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estu) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estu);
	}

}
