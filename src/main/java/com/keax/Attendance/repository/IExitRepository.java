package com.keax.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keax.Attendance.model.Exit; 

public interface IExitRepository extends JpaRepository<Exit, Integer> {

}
