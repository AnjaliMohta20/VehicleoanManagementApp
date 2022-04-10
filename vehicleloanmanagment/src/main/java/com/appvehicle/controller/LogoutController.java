package com.appvehicle.controller;

 

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserRegistrationEntity;
import com.appvehicle.service.LogoutServiceImpl;

 

@Controller
@RequestMapping("/api/vehicleloans")
public class LogoutController {

    @Autowired
    private LogoutServiceImpl logo;
    public static Logger logs = Logger.getLogger(UserRegistrationEntity.class.getName());
    
    

    // USED TO LOGOUT
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody UserRegistrationEntity userbasic) throws RecordNotFoundException{
        UserRegistrationEntity userRegis = logo.logout(userbasic);
        logs.info("Logged out succesfully");
        return new ResponseEntity("Logout Successful", HttpStatus.OK);

 

    }
 
}