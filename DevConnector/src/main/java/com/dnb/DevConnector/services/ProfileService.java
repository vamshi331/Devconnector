package com.dnb.DevConnector.services;

import java.util.Optional;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.InvalidEmailException;

public interface ProfileService {
	public Profile createProfile(Profile profile);
	public Optional<Profile> getProfileById(String Profilename);
    public boolean deleteProfileById(String Profilename)  ;
    public Iterable<Profile> getAllProfiles();
}
