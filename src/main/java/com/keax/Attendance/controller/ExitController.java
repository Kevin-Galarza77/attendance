package com.keax.Attendance.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keax.Attendance.model.Exit; 
import com.keax.Attendance.model.People;
import com.keax.Attendance.services.IExitService; 
import com.keax.Attendance.services.IPeopleService;

@RestController
@RequestMapping("/api/exit")
public class ExitController {

	@Autowired
	private IExitService exitService;
	@Autowired
	private IPeopleService peopleService;

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> registerIncome(@RequestBody Map<String, Object> request) {
		
		Map<String, Object> response = new HashMap<>();
		
		List<String> messages = validateDataForRegisterIncome(request);
		Boolean status = false;
		String alert = "Se ha producido un error al registrar el ingreso";

		if (messages.isEmpty()) {

			Optional<People> person = peopleService.findById((int) request.get("person"));

			if (person.isPresent()) {
				Exit exit= new Exit(); 
				exit.setLongitude((Double) request.get("longitude"));
				exit.setLatitude((Double) request.get("latitude"));
				exit.setPeople(person.get());
				exit.setTime(new Time(System.currentTimeMillis()));
				exit.setDate(new Date(System.currentTimeMillis()));

				Boolean incomeCreate = exitService.insert(exit);

				if (incomeCreate) {
					status = true;
					alert = "Se ha registrado la salida exitosamente";
				}

			} else {
				messages.add("No se ha encontrado a la persona");

			}
		}

		response.put("messages", messages);
		response.put("status", status);
		response.put("alert", alert);

		return ResponseEntity.ok(response);
	}

	private List<String> validateDataForRegisterIncome(@RequestBody Map<String, Object> request) {

		ValidateFieldController validate = new ValidateFieldController();
		List<String> messages = new ArrayList<String>();

		validate.validateField(request, "latitude", messages, "La latitud es requerida");
		validate.validateField(request, "longitude", messages, "la longitud es requerida");
		validate.validateField(request, "person", messages, "La persona es requerida");

		validate.validateFieldInteger(request, "person", messages, "La persona debe ser un valor entero");
		validate.validateFieldDouble(request, "latitude", messages, "La latitud debe ser un valor double");
		validate.validateFieldDouble(request, "longitude", messages, "La longitud debe ser un valor double");

		return messages;
	}

}
