package com.keax.Attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keax.Attendance.model.Income;
import com.keax.Attendance.repository.IIncomeRepository;
import com.keax.Attendance.services.IIncomeService;

@Service
@Component
public class IncomeServiceImp implements IIncomeService {

	@Autowired
	private IIncomeRepository incomeRepository;

	@Override
	public Boolean insert(Income income) {
		try {
			incomeRepository.save(income);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean update(Income income) {
		try {
			incomeRepository.save(income);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean delete(int id) {
		try {
			incomeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Income> list() {
		try {
			return incomeRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
