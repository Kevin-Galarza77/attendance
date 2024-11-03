package com.keax.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.keax.Attendance.model.PasswordReset;

public interface IPasswordResetRepository extends JpaRepository<PasswordReset, Integer> {

}
