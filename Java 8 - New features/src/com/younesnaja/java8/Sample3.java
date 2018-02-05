package com.younesnaja.java8;

interface Fly {
	default public void takeOff() {
		System.out.println("Fly::takeoff");
	}
	default public void turn() {
		System.out.println("Fly::turn");
	}
	default public void cruise() {
		System.out.println("Fly::cruise");
	}
	default public void land() {
		System.out.println("Fly::land");
	}
}

interface FastFly extends Fly {
	default public void takeOff() {
		System.out.println("FastFly::takeoff");
	}
}

class Vehicle {
	public void land() {
		System.out.println("Vehicle::land");
	}
}

class SeaPlane extends Vehicle implements FastFly {}

public class Sample3 {
	public void use() {
		SeaPlane seaPlane = new SeaPlane();
		seaPlane.takeOff();
		seaPlane.turn();
		seaPlane.cruise();
		seaPlane.land();
	}
	public static void main(String[] args) {
		new Sample3().use();

	}

}
