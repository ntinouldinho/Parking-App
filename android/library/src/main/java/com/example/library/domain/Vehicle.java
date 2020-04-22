package com.example.library.domain;

import com.example.library.util.Colour;

public class Vehicle {
	private Colour colour;
	private int size;
	private String text;
	private String plate;
	private String model;
	private String brand;

	@java.lang.Override
	public java.lang.String toString() {
		return "Vehicle{" +
				"colour=" + colour +
				", size=" + size +
				", text='" + text + '\'' +
				", plate='" + plate + '\'' +
				", model='" + model + '\'' +
				", brand='" + brand + '\'' +
				'}';
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPlate(String plate) {
		String letters = plate.substring(0,3).toUpperCase();
		for(int i=0;i<letters.length();i++){
			char letter = letters.charAt(i);
			if(letter<65 || letter>90) return;
		}
		String numbers = plate.substring(3);
		for(int i=0;i<numbers.length();i++){
			int number = Integer.valueOf(letters.charAt(i));
			if(number<0 || number>9) return;
		}
		if(letters.length()+numbers.length()!=7) return;

		this.plate = plate;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Colour getColour() {
		return colour;
	}

	public int getSize() {
		return size;
	}

	public String getText() {
		return text;
	}

	public String getPlate() {
		return plate;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}
}