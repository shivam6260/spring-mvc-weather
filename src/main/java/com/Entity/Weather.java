package com.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	private Double visibility;
	private String name;
	private Coordinate coord;
	private MainData main;
	public Double getVisibility() {
		return visibility;
	}
	public void setVisibility(Double visibility) {
		this.visibility = visibility;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinate getCoord() {
		return coord;
	}
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
	public MainData getMain() {
		return main;
	}
	public void setMain(MainData main) {
		this.main = main;
	}
	@Override
	public String toString() {
		return "Weather [visibility=" + visibility + ", name=" + name + ", coord=" + coord + ", main=" + main + "]";
	}
	

}
