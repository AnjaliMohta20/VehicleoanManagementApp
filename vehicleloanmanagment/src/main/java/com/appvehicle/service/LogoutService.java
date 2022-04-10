package com.appvehicle.service;

 

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserRegistrationEntity;

 

public interface LogoutService {
    
    // USED TO LOGOUT FOR USER
    public UserRegistrationEntity logout(UserRegistrationEntity userbasic) throws RecordNotFoundException;
    
}