package com.dnb.DevConnector.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.services.EducationService;
@RestController
@RequestMapping("/api/education")
public class EducationController {
	@Autowired
	EducationService educationService;
	
	@PostMapping("/create")
	public Education createEducation(@RequestBody Education education) {
		return education;
	}
	
@GetMapping("/getid/{edu_id}")
public ResponseEntity<?> getEducationById
(@PathVariable("edu_id") String edu_id) throws Exception {
	Optional<Education> optional = educationService.getEducationById(edu_id);
	if(optional.isPresent()) {
		return ResponseEntity.ok(optional.get());
	}
	else {
		throw new Exception("Id not valid");
	}
}


@DeleteMapping("/{exp_id}")
public ResponseEntity<?> deleteEducationById
(@PathVariable("edu_id") String edu_id) throws Exception{
	if(educationService.getEducationById(edu_id)!=null) {
		educationService.deleteEducationById(edu_id);
		return ResponseEntity.ok("Deleted");
	}
	else {
		throw new Exception("ID is not valid");
	}
}
}