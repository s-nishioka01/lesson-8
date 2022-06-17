package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Formula;
import com.example.demo.form.FormulaForm;
import com.example.demo.service.FormulaService;

@Controller
public class FormulaController {

	private final FormulaService formulaService;

	@Autowired
	public FormulaController(FormulaService formulaService) {
		this.formulaService = formulaService;
	}

	@GetMapping("/formula")
	public String index(Model model) {
		model.addAttribute("formulaList", formulaService.getFormulaList());
		model.addAttribute("error", "");
		return "formula";
	}

	@GetMapping("/new")
	public String newFormula(Model model) {
		return "new-formula";
	}

	@GetMapping("/edit/{id}")
	public String updateFormula(@PathVariable int id, Model model) {
		try {
			Formula formula = formulaService.findOne(id);
			int isMinus = 0;
			int isPlus = 1;
			if (formula.getPlusOrMinus().equals("−")) {
				isMinus = 1;
				isPlus = 0;
			}
			model.addAttribute("formula", formula);
			model.addAttribute("isMinus", isMinus);
			model.addAttribute("isPlus", isPlus);
			return "edit-formula";

		} catch (Exception e) {
			model.addAttribute("formulaList", formulaService.getFormulaList());
			model.addAttribute("error", "データが登録されていません");
			return "formula";
		}

	}

	@GetMapping("/delete/{id}")
	public String deleteFormula(@PathVariable int id, Model model) {
		try {
			model.addAttribute("formula", formulaService.findOne(id));
			return "delete-formula";

		} catch (Exception e) {
			model.addAttribute("formulaList", formulaService.getFormulaList());
			model.addAttribute("error", "データが登録されていません");
			return "formula";
		}

	}

	@PostMapping("/new")
	public String create(@Validated @ModelAttribute FormulaForm formulaForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "new-formula";
		}
		formulaService.saveFormulaList(formulaForm);
		return "redirect:/formula";
	}

	@PostMapping("/edit/{id}")
	public String update(@PathVariable int id, @Validated @ModelAttribute FormulaForm formulaForm, BindingResult result,
			Model model) throws Exception {
		try {
			if (result.hasErrors()) {
				List<String> errorList = new ArrayList<String>();
				for (ObjectError error : result.getAllErrors()) {
					errorList.add(error.getDefaultMessage());
				}
				model.addAttribute("formula", formulaService.findOne(id));
				model.addAttribute("validationError", errorList);
				return "edit-formula";
			}
			formulaForm.setId(id);
			formulaService.updateFormulaList(formulaForm);
			return "redirect:/formula";
		} catch (Exception e) {
			model.addAttribute("formulaList", formulaService.getFormulaList());
			model.addAttribute("error", e.getMessage());
			return "formula";
		}
	}

	@PostMapping("/delete/{id}")
	public String destroy(@PathVariable int id, Model model) throws Exception {
		try {
			formulaService.deleteFormulaList(id);
			return "redirect:/formula";
		} catch (Exception e) {
			model.addAttribute("formulaList", formulaService.getFormulaList());
			model.addAttribute("error", e.getMessage());
			return "formula";
		}

	}

}