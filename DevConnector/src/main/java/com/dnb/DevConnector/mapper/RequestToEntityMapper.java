package com.dnb.DevConnector.mapper;

import java.util.List;



import com.dnb.DevConnector.dto.Profile;

import com.dnb.DevConnector.payload.request.ProfileRequest;

import com.dnb.DevConnector.utils.DataStructureConversions;

 

public class RequestToEntityMapper {

//account.setAccountHolderName(accountRequest.getAccountHolderName());

public Profile getProfileEntityObject(ProfileRequest profileRequest)

{
	List<String> skillsetarr = profileRequest.getSkills();
	String StrSkills = DataStructureConversions.arrayToString(skillsetarr);
	Profile profile = new Profile();
	profile.setBio(profileRequest.getBio());
	profile.setCompany(profileRequest.getCompany());
	profile.setLocation(profileRequest.getLocation());
	profile.setStatus(profileRequest.getStatus());
	profile.setURL(profileRequest.getURL());
	profile.setUsername(profileRequest.getUsername());
	profile.setWebsite(profileRequest.getWebsite());
	profile.setSkills(StrSkills);
	return profile;

}

}
