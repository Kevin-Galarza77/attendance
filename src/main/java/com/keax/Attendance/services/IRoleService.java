package com.keax.Attendance.services;
 
import java.util.List;
import java.util.Optional;

import com.keax.Attendance.model.Role;

public interface IRoleService {

	public void insert(Role role);

	public void update(Role role);

	public void delete(int id);
	
	Optional<Role> findById(int id);
	
	List<Role> findByStatus(Boolean status);
	
}
