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

import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.services.ProfileService;
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	@PostMapping("/create")
	public Profile createProfile(@RequestBody Profile profile) {
		return profile;
	}
	
	@GetMapping("/getid/{Profile_ID}")
	public ResponseEntity<?> getProfileById
	(@PathVariable("Profile_ID") String Profile_ID) throws Exception {
		Optional<Profile> optional = profileService.getProfileById(Profile_ID);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new Exception("Id not valid");
		}
	}


	@DeleteMapping("/{Profile_ID}")
	public ResponseEntity<?> deleteProfileById
	(@PathVariable("Profile_ID") String Profile_ID) throws Exception{
		if(profileService.getProfileById(Profile_ID)!=null) {
			profileService.deleteProfileById(Profile_ID);
			return ResponseEntity.ok("Deleted");
		}
		else {
			throw new Exception("ID is not valid");
		}
	}
	
}
