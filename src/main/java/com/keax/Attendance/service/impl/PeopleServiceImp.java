package com.keax.Attendance.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keax.Attendance.model.People;
import com.keax.Attendance.repository.IPeopleRepository;
import com.keax.Attendance.services.IPeopleService;

@Service
@Component
public class PeopleServiceImp implements IPeopleService {

	@Autowired
	private IPeopleRepository peopleRepository;

	@Override
	public boolean insert(People people) {
		try {
			peopleRepository.save(people);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(People people) {
		try {
			peopleRepository.save(people);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			peopleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<People> findByStatus(Boolean status) {
		try {
			return peopleRepository.findByStatus(status);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public People findByPhone(String phone) {
		try {
			return peopleRepository.findByPhone(phone);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public People findByCardId(String cardId) {
		try {
			return peopleRepository.findByCardId(cardId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<People> findById(int id) {
		try {
			return peopleRepository.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
