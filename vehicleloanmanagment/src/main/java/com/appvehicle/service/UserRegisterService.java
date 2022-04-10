package com.appvehicle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserRegistrationEntity;
 
@Service
public interface UserRegisterService 
{
    
    // ADDING AN USER
    public UserRegistrationEntity userRegister(UserRegistrationEntity userbasic) throws DuplicateRecordException;
 
    //PASSWORD RESET
    public List<UserRegistrationEntity> passwordReset(UserRegistrationEntity userbasic)throws RecordNotFoundException;
 
    //GET USER BY EMAIL
    public UserRegistrationEntity showUserRegistrationInformationByEmail(String email)throws RecordNotFoundException;
 
    //GET ALL USERS
    public List<UserRegistrationEntity> getAllUsers()throws RecordNotFoundException;
}
