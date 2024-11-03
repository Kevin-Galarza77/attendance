package com.keax.Attendance;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.keax.Attendance.services.IPeopleService;

@SpringBootTest
class AttendanceApplicationTests {

	@Autowired
	IPeopleService peopleService;
	
	@Test
	void contextLoads() {
		
		
		
	}

}
