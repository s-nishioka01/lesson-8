package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formula;
import com.example.demo.form.FormulaForm;
import com.example.demo.mapper.FormulaMapper;

@Service
public class FormulaService {

	private final FormulaMapper formulaMapper;

	@Autowired
	public FormulaService(FormulaMapper formulaMapper) {
		this.formulaMapper = formulaMapper;
	}

	public LocalDate calculateDate(Formula formula, LocalDate date) throws Exception {
		LocalDate result;
		if (formula.getPlusOrMinus().equals("＋")) {
			result = date.plusYears(formula.getYear()).plusMonths(formula.getMonth()).plusDays(formula.getDay());
			return result;
		} else if (formula.getPlusOrMinus().equals("−")) {
			result = date.minusYears(formula.getYear()).minusMonths(formula.getMonth()).minusDays(formula.getDay());
			return result;
		} else {
			throw new Exception("この計算式は有効ではありません");
		}
	}

	public List<Formula> getFormulaList() {
		return formulaMapper.findAll();
	}

	public Formula findOne(int id) throws Exception {
		return formulaMapper.findOne(id).orElseThrow(() -> new Exception("計算式が登録されていません"));
	}

	public void saveFormulaList(FormulaForm formulaForm) {
		formulaMapper.save(formulaForm);
	}

	public void updateFormulaList(FormulaForm formulaForm) {
		formulaMapper.update(formulaForm);
	}

	public void deleteFormulaList(int id) {
		formulaMapper.delete(id);
	}

}