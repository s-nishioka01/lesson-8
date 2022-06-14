package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

public class FormulaForm {

	private int id;

	@Length(max = 30, message = "30文字以内で入力してください")
	@NotBlank(message = "計算式名が未入力です")
	private String name;

	@PositiveOrZero(message = "0または正数を入力してください")
	@Max(value = 1000, message = "年の計算値の上限は1000です")
	@NotNull(message = "計算値が未入力です")
	private int year;

	@PositiveOrZero(message = "0または正数を入力してください")
	@Max(value = 10000, message = "月の計算値の上限は10000です")
	@NotNull(message = "計算値が未入力です")
	private int month;

	@PositiveOrZero(message = "0または正数を入力してください")
	@Max(value = 500000, message = "日の計算値の上限は500000です")
	@NotNull(message = "計算値が未入力です")
	private int day;

	@NotBlank(message = "「前」または「後」を選択してください")
	private String plusOrMinus;

	public FormulaForm(int id, String name, int year, int month, int day, String plusOrMinus) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.plusOrMinus = plusOrMinus;
	}

	public FormulaForm() {

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