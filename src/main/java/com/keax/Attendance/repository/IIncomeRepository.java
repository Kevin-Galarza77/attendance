package com.keax.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.keax.Attendance.model.Income;

public interface IIncomeRepository extends JpaRepository<Income, Integer> {

}
