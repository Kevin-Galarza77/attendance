package com.keax.Attendance.controller;

import java.sql.Timestamp;
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

import com.keax.Attendance.model.People;
import com.keax.Attendance.model.Role;
import com.keax.Attendance.model.User;
import com.keax.Attendance.services.IPeopleService;
import com.keax.Attendance.services.IRoleService;
import com.keax.Attendance.services.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IPeopleService peopleService;
	@Autowired
	private IRoleService roleService;

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Map<String, Object> request) {

		Map<String, Object> response = new HashMap<>();
		
		List<String> messages = validateDataForRegisterUser(request);
		Boolean status = false;
		String alert = "Se ha producido un error al registrar el usuario";

		if (messages.isEmpty()) {

			User user = new User();
			user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			user.setUpdatedAt(null);
			user.setPassword((String) request.get("password"));
			user.setStatus((Boolean) request.get("status"));
			user.setEmail((String) request.get("email"));
			
			Optional<Role> optionalRole = roleService.findById((int) request.get("rol"));
			Boolean createUser = false;

			if (optionalRole.isPresent()) { 
				user.setRole(optionalRole.get());
				createUser = userService.insert(user);
			}
			
			if (createUser) {
				People person = new People();
				person.setFirstName((String) request.get("first_name"));
				person.setLastName((String) request.get("last_name"));
				person.setAddress((String) request.get("address"));
				person.setStatus((Boolean) request.get("status"));
				person.setCardId((String) request.get("card_id"));
				person.setPhone((String) request.get("phone"));
				person.setUser(user);
				
				Boolean createPerson = peopleService.insert(person);
				
				if (createPerson) {
					alert = "Se ha registrado el usuario correctamente";
					status = true;
				} else {
					alert = "Se ha producido un error al crear el empleado";
					userService.delete(user.getUserId());
				}
				
			}else {
				alert = "Se ha producido un error al crear el usuario";
			}

		}

		response.put("messages", messages);
		response.put("status", status);
		response.put("alert", alert);
	
		return ResponseEntity.ok(response);
	}

	private List<String> validateDataForRegisterUser(@RequestBody Map<String, Object> request) {

		ValidateFieldController validate = new ValidateFieldController();
		List<String> messages = new ArrayList<String>();

		validate.validateField(request, "email", messages, "El email es requerido");
		validate.validateField(request, "password", messages, "La contraseña es requerida");
		validate.validateField(request, "status", messages, "El estado es requerida");
		validate.validateField(request, "rol", messages, "El rol es requerida");
		validate.validateField(request, "first_name", messages, "El nombre es requerida");
		validate.validateField(request, "last_name", messages, "El apellido es requerida");
		validate.validateField(request, "card_id", messages, "El número de cédula es requerida");
		validate.validateField(request, "phone", messages, "El celular es requerida");
		validate.validateField(request, "address", messages, "La dirección es requerida");

		validate.validateFieldByPattern(request, "email", messages, "El formato del email es inválido",
				"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		validate.validateFieldByPattern(request, "password", messages,
				"La contraseña debe tener almenos 8 carácteres entre ellos una letra minúscula, mayúscula, un dígito y un carácter especial (?=.*[@$!%*?&])",
				"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
		validate.validateFieldBoolean(request, "status", messages, "El estado debe ser true o false");
		validate.validateFieldInteger(request, "rol", messages, "El rol debe ser un valor entero");
		validate.validateFieldByPattern(request, "card_id", messages, "El número de cédula debe ser de 10 digítos", "^\\d{10}$");
		validate.validateFieldByPattern(request, "phone", messages, "El celular debe ser de 10 digítos", "^\\d{10}$");
		
		if (request.containsKey("email") && validate.isValidPattern("email", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			User user = userService.findByEmail((String) request.get("email"));
			if (user != null) {
				messages.add("El email ya ha sido registrado");
			}
		}
		
		if (request.containsKey("card_id") && validate.isValidPattern("card_id", "^\\d{10}$")) {
			People person = peopleService.findByCardId((String) request.get("card_id"));
			if (person != null) {
				messages.add("El número de cédula ya ha sido registrado");
			}
		}
		
		if (request.containsKey("phone") && validate.isValidPattern("phone", "^\\d{10}$")) {
			People person = peopleService.findByPhone((String) request.get("phone"));
			if (person != null) {
				messages.add("El celular ya ha sido registrado");
			}
		}
		
		return messages;
	}

}
