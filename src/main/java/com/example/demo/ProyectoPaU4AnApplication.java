package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.paralelo.modelo.Ciudadano;
import com.example.demo.paralelo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoPaU4AnApplication implements CommandLineRunner{

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		procesarEstudiantesParalelo();
	}
	
	public void procesarEstudiantesParalelo() {
		long tiempoInicial= System.currentTimeMillis();
		List<Ciudadano> listaC = new ArrayList<>();
		listaC=this.ciudadanoService.consultarTodos();
				
		listaC.parallelStream().forEach(ciu -> this.ciudadanoService.convertir(ciu));		 
		long tiempoFinal= System.currentTimeMillis();
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial);
		System.out.println("Tiempo transcurrido: "+tiempoTranscurrido+" milisegundos");
	}

}
