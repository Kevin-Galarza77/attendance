package com.keax.Attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keax.Attendance.model.People;

public interface IPeopleRepository extends JpaRepository<People, Integer> {

	People findByPhone(String phone);

	People findByCardId(String cardId);

	List<People> findByStatus(Boolean status);

}
