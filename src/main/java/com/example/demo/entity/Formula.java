package com.example.demo.entity;

public class Formula {

	private int id;

	private String name;

	private int year;

	private int month;

	private int day;

	private String plusOrMinus;

	public Formula(int id, String name, int year, int month, int day, String plusOrMinus) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.plusOrMinus = plusOrMinus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getPlusOrMinus() {
		return plusOrMinus;
	}

	public void setPlusOrMinus(String plusOrMinus) {
		this.plusOrMinus = plusOrMinus;
	}

}