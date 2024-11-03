package com.keax.Attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keax.Attendance.model.Exit;
import com.keax.Attendance.repository.IExitRepository;
import com.keax.Attendance.services.IExitService;

@Service
@Component
public class ExitServiceImp implements IExitService {

	@Autowired
	private IExitRepository exitRepository;

	@Override
	public Boolean insert(Exit exit) {
		try {
			exitRepository.save(exit);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean update(Exit exit) {
		try {
			exitRepository.save(exit);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean delete(int id) {
		try {
			exitRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Exit> list() {
		try {
			return exitRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
