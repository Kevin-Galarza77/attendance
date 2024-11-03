package com.keax.Attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keax.Attendance.model.PasswordReset; 
import com.keax.Attendance.repository.IPasswordResetRepository;
import com.keax.Attendance.services.IPasswordResetService;

@Service
@Component
public class PasswordResetServiceImp implements IPasswordResetService{

	@Autowired
	private IPasswordResetRepository passwordResetRepository;
	
	@Override
	public void insert(PasswordReset passwordReset) {
		try {
			passwordResetRepository.save(passwordReset);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update(PasswordReset passwordReset) {
		try {
			passwordResetRepository.save(passwordReset);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			passwordResetRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
