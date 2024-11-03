package com.keax.Attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.keax.Attendance.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

	List<Role> findByStatus(Boolean status);
	
}
