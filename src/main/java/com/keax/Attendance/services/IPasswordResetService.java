package com.keax.Attendance.services;
  

import com.keax.Attendance.model.PasswordReset;
  
public interface IPasswordResetService {

	public void insert(PasswordReset passwordReset);

	public void update(PasswordReset passwordReset);

	public void delete(int id);
	
}
