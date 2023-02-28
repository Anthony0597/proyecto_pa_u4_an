package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainSecuencial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> idEstudiantes = new ArrayList<>();
		for(int i=1; i<=10;i++) {
			idEstudiantes.add(i);
		}
		 idEstudiantes.forEach(numero -> System.out.println("Estudiante: "+numero));
		 long tiempoInicial= System.currentTimeMillis();
		 //Procesar estudiantes
		 List<String> listadoEstudiante = new ArrayList<>();
		 for(Integer i:idEstudiantes) {
			listadoEstudiante.add(procesarIdEstudiante(i)); 
		 }
		 long tiempoFinal= System.currentTimeMillis();
		 long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		 listadoEstudiante.forEach(cadena -> System.out.println(cadena));
		 System.out.println("Tiempo transcurrido: "+tiempoTranscurrido);
	}
	
	public static String procesarIdEstudiante(Integer idEstudiante) {
		//Convertir a string
		String idConvertido="E"+idEstudiante.toString();
		//Se inserta en la base
		System.out.println("Insertando estudiante: "+idConvertido+" hilo: "+Thread.currentThread().getName());
		//1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idConvertido;
	}

}
