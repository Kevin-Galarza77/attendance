package com.keax.Attendance.services;
 
import java.util.List;
import java.util.Optional;

import com.keax.Attendance.model.People; 
 
public interface IPeopleService {

	public boolean insert(People people);

	public boolean update(People people);

	public boolean delete(int id);
	
	People findByPhone(String phone);
	
	People findByCardId(String cardId);
	
	Optional<People> findById(int id);
	
	List<People> findByStatus(Boolean status);
	
}
