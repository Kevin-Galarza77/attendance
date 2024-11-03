package com.keax.Attendance.services;
 
import java.util.List;
 
import com.keax.Attendance.model.Income;
 
public interface IIncomeService {

	public Boolean insert(Income income);

	public Boolean update(Income income);

	public Boolean delete(int id);
	
	public List<Income> list();
}
