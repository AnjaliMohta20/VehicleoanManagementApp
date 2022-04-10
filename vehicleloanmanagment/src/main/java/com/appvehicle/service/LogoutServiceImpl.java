package com.appvehicle.service;

 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appvehicle.dao.UserRegisterJPARepository;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserRegistrationEntity;

 

//LOGOUT IMPLEMENTATION 
@Service
public class LogoutServiceImpl implements LogoutService {

 


    @Autowired
    private UserRegisterJPARepository userRegisterRepo;
    // USED TO LOGOUT
        @Override
        public UserRegistrationEntity logout(UserRegistrationEntity userbasic)throws RecordNotFoundException {
            // TODO Auto-generated method stub
            Optional<UserRegistrationEntity> userbasics = userRegisterRepo.findById(userbasic.getEmail());
            if (!userbasics.isPresent()) 
            {
                return null;
            } else
                return userbasics.get();
        }
}