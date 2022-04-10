package com.appvehicle.controller;
 
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserRegistrationEntity;
import com.appvehicle.service.UserRegisterServiceImpl;
 
//UserRegisterController class
@Controller
@RequestMapping("/api/vehicleloans")
public class UserRegisterController 
{
 
    // Autowired with UserRegisterService
    @Autowired
    private UserRegisterServiceImpl userRegis;
 
    // Log
    public static Logger log = Logger.getLogger(UserRegistrationEntity.class.getName());
    
 // ADDING THE USER DETAILS
    @PostMapping("/userregister")
    public ResponseEntity<UserRegistrationEntity> userRegister(@Valid @RequestBody UserRegistrationEntity userbasic) throws DuplicateRecordException 
    {
        UserRegistrationEntity userRegister = userRegis.userRegister(userbasic);
        return new ResponseEntity<UserRegistrationEntity>(userRegister, HttpStatus.OK);
    }
//    @PostMapping("/userregister/r")
//    public String userRegister(@Valid UserRegistrationEntity userbasic) throws DuplicateRecordException 
//    {
//        UserRegistrationEntity userRegister = userRegis.userRegister(userbasic);
////        return new ResponseEntity<UserRegistrationEntity>(userRegister, HttpStatus.OK);
//        return "userdetails";
//    }
 
    // GET USER DETAILS BY EMAIL
    @GetMapping("/userregister/{email}")
    public ResponseEntity<UserRegistrationEntity> showUserRegistrationInformation(@PathVariable("email") String email)
            throws RecordNotFoundException 
            {
        UserRegistrationEntity userRegister = userRegis.showUserRegistrationInformationByEmail(email);
        return new ResponseEntity<UserRegistrationEntity>(userRegister, HttpStatus.OK);
            }
 
    // GET ALL USER DETAILS
    @GetMapping("/userregister")
    public ResponseEntity<List<UserRegistrationEntity>> getAllUsers()
            throws RecordNotFoundException 
            {
        log.info("getAllUsers");
        List<UserRegistrationEntity> userRegister = userRegis.getAllUsers();
        return new ResponseEntity<List<UserRegistrationEntity>>(userRegister, HttpStatus.OK);
            }
 
    // UPDATE THE PASSWORD OF USER
    @PutMapping("/userregister")
    public ResponseEntity<List<UserRegistrationEntity>> passwordReset(
            @Valid @RequestBody UserRegistrationEntity userbasic) throws RecordNotFoundException 
    {
        List<UserRegistrationEntity> userRegister = userRegis.passwordReset(userbasic);
        return new ResponseEntity<List<UserRegistrationEntity>>(userRegister, HttpStatus.OK);
    }
 
}
 