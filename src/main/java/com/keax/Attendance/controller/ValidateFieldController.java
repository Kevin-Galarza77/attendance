package com.keax.Attendance.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidateFieldController {

	public void validateField(Map<String, Object> request, String key, List<String> messages, String errorMessage) {
		if (!request.containsKey(key) || request.get(key) == null) {
			messages.add(errorMessage);
		} else {
			Object value = request.get(key);
			String valueAsString = value.toString();
			if (valueAsString.isEmpty()) {
				messages.add(errorMessage);
			}
		}
	}

	public void validateFieldByPattern(Map<String, Object> request, String key, List<String> messages,
			String errorMessage, String part) {
		if (request.containsKey(key)) {
			String input = request.get(key).toString();
			if (isValidPattern(input, part)) {
				messages.add(errorMessage);
			}
		}
	}

	public void validateFieldBoolean(Map<String, Object> request, String key, List<String> messages,
			String errorMessage) {
		if (request.containsKey(key) && !(request.get(key) instanceof Boolean)) {
			messages.add(errorMessage);
		}
	}

	public void validateFieldInteger(Map<String, Object> request, String key, List<String> messages,
			String errorMessage) {
		if (request.containsKey(key) && !(request.get(key) instanceof Integer)) {
			messages.add(errorMessage);
		}
	}
	
	public void validateFieldDouble(Map<String, Object> request, String key, List<String> messages,
			String errorMessage) {
		if (request.containsKey(key) && !(request.get(key) instanceof Double)) {
			messages.add(errorMessage);
		}
	}

	public boolean isValidPattern(String input, String part) {
		return !Pattern.compile(part).matcher(input).matches();
	}

}
