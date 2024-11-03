package com.keax.Attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keax.Attendance.model.Role;
import com.keax.Attendance.services.IRoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> show(@PathVariable String id) {

		Map<String, Object> response = new HashMap<>();

		List<Role> data = new ArrayList<Role>();
		Boolean status = false;
		String alert = "No se pudo encontrar la información";

		switch (id) {
		case "activates": {
			data = roleService.findByStatus(true);
			if (data.size() != 0) {
				status = true;
				alert = "Se han encontrado todos los roles activos";
			}
		}
		}

		response.put("alert", alert);
		response.put("status", status);
		response.put("data", data);

		return ResponseEntity.ok(response);
	}

}
