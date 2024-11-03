package com.keax.Attendance.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keax.Attendance.model.Role;
import com.keax.Attendance.repository.IRoleRepository;
import com.keax.Attendance.services.IRoleService;

@Service
@Component
public class RoleServiceImp implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public void insert(Role role) {
		try {
			roleRepository.save(role);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update(Role role) {
		try {
			roleRepository.save(role);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			roleRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Role> findByStatus(Boolean status) {
		try {
			return roleRepository.findByStatus(status);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<Role> findById(int id) {
		try {
			return roleRepository.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
