package com.cts.engineAnalysis;

public class Car {
	
    private String name;
	private Engine engine;
	public Car(String name, Engine engine) {
		this.name = name;
		this.engine = engine;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	// Type your code here
	
	public void getReport(){
		
    // Type your code here
    System.out.println(name+" car with "+engine.getFuel()+" engine gives "+engine.getPerformance()+" horsepower");
		
	}

}
