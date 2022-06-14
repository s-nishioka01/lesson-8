package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Formula;
import com.example.demo.form.CalculationForm;
import com.example.demo.service.FormulaService;

@Controller
public class CalculationController {

	private final FormulaService formulaService;

	@Autowired
	public CalculationController(FormulaService formulaService) {
		this.formulaService = formulaService;
	}

	@GetMapping("/top")
	public String top(Model model) throws Exception {

		LocalDate today = LocalDate.now();
		model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		model.addAttribute("formulaList", formulaService.getFormulaList());
		model.addAttribute("error", "");
		return "top";

	}

	@PostMapping("/calculate")
	public String calculate(@ModelAttribute("formula") int id,
			@Validated @ModelAttribute CalculationForm calculationForm, Model model, BindingResult bindingResult)
			throws Exception {

		try {

			Formula formula = formulaService.findOne(id);
			LocalDate date = LocalDate.parse(calculationForm.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate result;

			if (formula.getPlusOrMinus().equals("＋")) {
				result = date.plusYears(formula.getYear()).plusMonths(formula.getMonth()).plusDays(formula.getDay());
			} else if (formula.getPlusOrMinus().equals("−")) {
				result = date.minusYears(formula.getYear()).minusMonths(formula.getMonth()).minusDays(formula.getDay());
			} else {
				LocalDate today = LocalDate.now();
				model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				model.addAttribute("formulaList", formulaService.getFormulaList());
				model.addAttribute("error", "この計算式は有効ではありません");
				return "top";
			}

			model.addAttribute("date", date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
			model.addAttribute("formula", formula.getName());
			model.addAttribute("result", result.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
			return "result";

		} catch (Exception e) {

			if (calculationForm.getDate() == "") {
				LocalDate today = LocalDate.now();
				model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				model.addAttribute("formulaList", formulaService.getFormulaList());
				model.addAttribute("error", "日付が入力されていません");
				return "top";
			} else {
				LocalDate today = LocalDate.now();
				model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				model.addAttribute("formulaList", formulaService.getFormulaList());
				model.addAttribute("error", "計算式が登録されていません");
				return "top";
			}

		}

	}

}