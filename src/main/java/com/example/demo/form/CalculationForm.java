package com.example.demo.form;

import org.springframework.format.annotation.DateTimeFormat;

public class CalculationForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;

	public CalculationForm(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}