package com.example.demo.paralelo.service;

import java.util.List;

import com.example.demo.paralelo.modelo.Ciudadano;

public interface ICiudadanoService {
	public List<Ciudadano> consultarTodos();
	public void convertir(Ciudadano ciu);
}
