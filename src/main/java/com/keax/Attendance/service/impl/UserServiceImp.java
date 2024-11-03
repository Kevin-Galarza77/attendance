package com.keax.Attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keax.Attendance.model.User;
import com.keax.Attendance.repository.IUserRepository;
import com.keax.Attendance.services.IUserService;

@Service
@Component
public class UserServiceImp implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public boolean insert(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public User findByEmail(String email) {
		try {
			return userRepository.findByEmail(email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
