package com.keax.Attendance.services;

import java.util.List;

import com.keax.Attendance.model.Exit;

public interface IExitService {

	public Boolean insert(Exit exit);

	public Boolean update(Exit exit);

	public Boolean delete(int id);
	
	public List<Exit> list();

}
