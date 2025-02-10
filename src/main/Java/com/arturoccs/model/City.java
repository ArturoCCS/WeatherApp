package com.arturoccs.model;

public class City {
	private String name;
	private Coord coord;
	
	
	
	public City(String name, Coord coord) {
		this.name = name;
		this.coord = coord;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}



	@Override
	public String toString() {
		return "City [ name=" + name +  ", coord=" + coord + "]";
	}
	
	
	
}
