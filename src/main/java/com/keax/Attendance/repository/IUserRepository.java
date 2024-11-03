package com.keax.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.keax.Attendance.model.User;
import java.util.List;


public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
}
