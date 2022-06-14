package com.example.demo.service;

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

	public List<Formula> getFormulaList() {
		return formulaMapper.findAll();
	}

	public Formula findOne(int id) throws Exception {
		return formulaMapper.findOne(id).orElseThrow(() -> new Exception("計算式が登録されていませんa"));
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