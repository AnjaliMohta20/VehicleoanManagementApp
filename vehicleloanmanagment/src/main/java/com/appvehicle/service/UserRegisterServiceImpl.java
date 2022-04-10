package com.appvehicle.service;



import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appvehicle.dao.UserRegisterJPARepository;
import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserRegistrationEntity;
 
//UserRegisterServiceImpl class
@Service
public class UserRegisterServiceImpl implements UserRegisterService 
{
 
    static Logger log = Logger.getLogger(UserRegisterServiceImpl.class.getClass());
 
    // Autowired with UserRegisterJPARepository
    @Autowired
    private UserRegisterJPARepository userRegisterDao;
 
    //TO ADD USERDETAILS
    @Override
    public UserRegistrationEntity userRegister(UserRegistrationEntity userbasic) throws DuplicateRecordException 
    {
        log.info("Service Layer-Entry-userRegister");
        UserRegistrationEntity user = new UserRegistrationEntity();
        if (userbasic.getEmail().isEmpty()) 
        {
            log.warn("WARN:Email should not be Empty");
            throw new DuplicateRecordException("User details should not be null");
        }
        log.info("Service Layer-Exit-userRegister");
        user = userRegisterDao.saveAndFlush(userbasic);
        return user;
    }
 
    //TO SHOW USER INFORMATION BY EMAIL
    @Override
    public UserRegistrationEntity showUserRegistrationInformationByEmail(String email) throws RecordNotFoundException
    {
    	if(email==null) {
    		throw new RecordNotFoundException("Null email entered");
    	}
        log.info("Service Layer-Entry-showUserRegistrationInformation");
        Optional<UserRegistrationEntity> userbasic = userRegisterDao.findById(email);
        if (userbasic==null) 
        {
            log.warn("WARN:Details should not be null");
            throw new RecordNotFoundException("User details not found");
        }
        log.info("Service Layer-Exit-showUserRegistrationInformation");
        return userbasic.get();
    }
 
    // TO UPDATE THE PASSWORD OF THE USER
    @Override
    public List<UserRegistrationEntity> passwordReset(UserRegistrationEntity userbasic) throws RecordNotFoundException 
    {
        log.info("Service Layer-Entry-passwordReset");
        if (userbasic.getEmail().isEmpty()) 
        {
            log.warn("WARN:Email should not be null");
            throw new RecordNotFoundException("User Email not found");
        }
        log.info("Service Layer-Exit-passwordReset");
 
        userRegisterDao.save(userbasic);
        return userRegisterDao.findAll();
    }
    
  //TO GET ALL THE USER DETAILS
    @Override
    public List<UserRegistrationEntity> getAllUsers() throws RecordNotFoundException
    {
        log.info("Service Layer-Entry-getAllUsers");
        
        log.info("Service Layer-Exit-getAllUsers");
        return userRegisterDao.findAll();
 
    }
 
}
 
    
    
    
 
