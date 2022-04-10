package com.appvehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appvehicle.dao.AdminJPARepository;
import com.appvehicle.dao.LoanApplicationJPARepository;
import com.appvehicle.dao.UserRegisterJPARepository;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.exceptions.RegistrationException;
import com.appvehicle.model.AdminEntity;
import com.appvehicle.model.UserRegistrationEntity;


@Service
public class LoginDtoServiceImpl implements LoginDtoService {
	@Autowired 
	UserRegisterJPARepository userRepo;
    @Autowired
    AdminJPARepository adminRepo;
    @Autowired
    LoanApplicationJPARepository loanRepo;
	@Override
	
	/* method for verifying user Sign in */
	
	public UserRegistrationEntity authenticateUser(String userEmail,String password) throws RegistrationException, RecordNotFoundException {
       
		// condition for improper details
		if(userEmail.equals("")  || password==null) {
        	throw new RegistrationException("Invalid Details! please enter correct details");                   
        } 
        else {
        Optional<UserRegistrationEntity> user=userRepo.findById(userEmail);
        //condition if record not exists in database
        if(!user.isPresent())
        	throw new RecordNotFoundException("No record exists for given user"); 
         // condition for if record present and password does not matches
        if(user.isPresent() && !(user.get().getPassword().equals(password)))
        	throw new RegistrationException("password does not matches");
        return user.get(); }
	}  
	
	
	/* method for verifying admin sign in */

	@Override 
	public List<UserRegistrationEntity> getAllUsersDetails() {  
		return userRepo.findAll();
	}
	public AdminEntity authenticateAdmin(String adminEmail,String password) throws RegistrationException, RecordNotFoundException
	{
		// condition for improper details
		if(adminEmail.equals("") || password==null)  
			throw new RegistrationException("Invalid Details! please enter correct details");else {
		Optional<AdminEntity> admin=adminRepo.findById(adminEmail);
		//condition if record not exists in database 
	        if(!admin.isPresent())
	        	throw new RecordNotFoundException("No Record Exists for given Admin");
	     // condition for if record present and password does not matches
	        if(admin.isPresent() && !(admin.get().getPassword().equals(password)))
	        	throw new RegistrationException("Password does not match");
	        return admin.get();}
		
	}

	@Override
	public List<AdminEntity> getAllAdminDetails() {
		return adminRepo.findAll();
	}

	

}