package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		//Supplier
		LOG.info("1. SUPPLIER");
		//Clases
		IPersonaSupplier <String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier.class:"+supplier1.getNombre());
		//Lambda
		IPersonaSupplier<String> supplier2 = () -> "Edison 2";
		LOG.info("Supplier.class:"+supplier2.getNombre());
		
		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier.class:"+supplier3.getNombre());
		
		IPersonaSupplier<Persona> supplier4 = () -> {Persona per=new Persona();
													per.setNombre("Anthony");
													per.setApellido("Naranjo");
													return per;};
		LOG.info("Supplier.class:"+supplier4.getNombre());
		
		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier.class:"+supplier5.getNombre());
		
		//Consumer
		LOG.info("2. CONSUMER");
		//Clase
		IPersonaConsumer<String, Integer> consumer1= new PersonaConsumerImpl();
		consumer1.accept("procesa este dato", Integer.valueOf(10));
		//Lambda
		IPersonaConsumer<String, Integer> consumer2 = (cadena,numero) -> {
			LOG.info("mensaje A:"+cadena);
			LOG.info("mensaje B:"+cadena);
			LOG.info("mensaje C:"+numero);};
		consumer2.accept("procesa este dato 2", Integer.valueOf(15));
		
		IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2)->{
			Integer valor3 = valor1.intValue()+valor2.intValue();
			LOG.info("valor 3="+valor3);
		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));
		
		//Predicate
		LOG.info("3. PREDICATE");
		//Lambdas
		IPersonaPredicate<String> predicate1 = cadena -> cadena.contains("Z");
		LOG.info("Predicate: "+predicate1.evaluar("AnthonyZ"));
		
		IPersonaPredicate<Integer> predicate2 = numero -> {
			if(numero.intValue()>10) {
				return true;
			}else {
				return false;
			}
		};
		LOG.info("Predicate 2: "+predicate2.evaluar(Integer.valueOf(11)));
		
		//Function
		LOG.info("4. FUNCTION");
		//Lambdas
		IPersonaFunction<String, Integer> function1 = numero -> "Valor: "+numero.toString();
		LOG.info(function1.aplicar(10));
		
		IPersonaFunction<Ciudadano, Persona> function2 = per -> {
			Ciudadano ciu = new Ciudadano();
			ciu.setNombreCompleto(per.getNombre()+" "+per.getApellido());
			ciu.setCiudad("Quito");
			return ciu;
		};
		Persona persona=new Persona();
		persona.setNombre("Anthony");
		persona.setApellido("Naranjo");
		Ciudadano ciudadanoConvertido = function2.aplicar(persona);
		LOG.info("Ciudadano convertido: "+ciudadanoConvertido);
		
		//UnaryOperator
		LOG.info("5. UNARYOPERATOR");
		//Lambdas
		IPersonaUnaryOperator<String> unaryOperator = cadena -> {
			String cadenaFinal=cadena.concat("-sufijo");
			return cadenaFinal;
		};
		LOG.info("UnaryOperator: "+unaryOperator.aplicar("Daniel"));
	}

}
