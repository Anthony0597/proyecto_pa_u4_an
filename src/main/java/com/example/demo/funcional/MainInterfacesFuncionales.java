package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		//Supplier
		LOG.info("1. SUPPLIER");
		//JAVA
		LOG.info("Java Supplier");
		Stream<String> lista =  Stream.generate(()->{
			String cadena ="test";
			return "Anthony 2";}).limit(10);
		lista.forEach(cadena -> LOG.info(cadena));
		
		//Consumer
		LOG.info("2. CONSUMER");
		//JAVA
		LOG.info("Java Consumer");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,56,78);
		listaNumeros.forEach(numero -> LOG.info("valor: "+numero));
		
		for(Integer val:listaNumeros) {
			LOG.info("valor: "+val);
		}
		
		//Predicate
		LOG.info("3. PREDICATE");
		//JAVA
		LOG.info("Java Predicate");
		Stream<Integer> listaFiltrda =listaNumeros.stream().filter(numero -> numero >=3);
		listaFiltrda.forEach(numero -> LOG.info("Valor:"+numero));
		
		//Function
		LOG.info("4. FUNCTION");
		//JAVA
		LOG.info("Java Function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valorFinal=numeroLista+1;
			String cadena="num: "+valorFinal.toString();
			return cadena;
		});
		listaCambiada.forEach(cadena->LOG.info(cadena));
		
		//UnaryOperator
		LOG.info("5. UNARYOPERATOR");
		//JAVA
		LOG.info("Java UnaryOperator");
		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numeroLista -> {
			Integer valorFinal=numeroLista+1;
			return valorFinal;
		});
		listaCambiada2.forEach(numero->LOG.info("valor entero: "+numero));
	}

}
