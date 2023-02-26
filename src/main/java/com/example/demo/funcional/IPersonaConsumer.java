package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaConsumer <T,U>{
	public void accept(T arg1, U arg2);
}
