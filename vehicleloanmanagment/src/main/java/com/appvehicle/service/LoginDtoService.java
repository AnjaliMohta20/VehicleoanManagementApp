package com.appvehicle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.exceptions.RegistrationException;
import com.appvehicle.model.AdminEntity;
import com.appvehicle.model.UserRegistrationEntity;


@Service
public interface LoginDtoService {
	
	public UserRegistrationEntity authenticateUser(String userEmail,String password) throws RegistrationException, RecordNotFoundException ;
   
	public List<UserRegistrationEntity> getAllUsersDetails();
   
	public AdminEntity authenticateAdmin(String adminEmail,String password) throws RegistrationException, RecordNotFoundException;
   
	public List<AdminEntity> getAllAdminDetails();
   

}