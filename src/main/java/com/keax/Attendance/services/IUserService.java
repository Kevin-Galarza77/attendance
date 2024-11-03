package com.keax.Attendance.services;
 
import com.keax.Attendance.model.User;

public interface IUserService {

	public boolean insert(User user);

	public boolean update(User user);

	public boolean delete(int id);
	
	User findByEmail(String email);
	
}
