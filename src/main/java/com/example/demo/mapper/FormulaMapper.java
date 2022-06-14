package com.example.demo.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Formula;
import com.example.demo.form.FormulaForm;

@Mapper
public interface FormulaMapper {

	List<Formula> findAll();

	Optional<Formula> findOne(int id);

	void save(FormulaForm formulaForm);

	void update(FormulaForm formulaForm);

	void delete(int id);
}