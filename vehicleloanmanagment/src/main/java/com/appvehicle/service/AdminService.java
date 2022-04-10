package com.appvehicle.service;
 

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.AdminEntity;
@Service
public interface AdminService {

 
    //ADDING AN ADMIN
    public AdminEntity adminRegister(AdminEntity admin) throws RecordNotFoundException;            
    
    //GET ADMIN BY EMAIL
    public AdminEntity showAdminDetailsByEmail(String email) throws RecordNotFoundException;        
    
    //UPDATING AN ADMIN
    public List<AdminEntity> updateAdmin(AdminEntity admin) throws RecordNotFoundException;    
        
    //GET ALL ADMINS
    public List<AdminEntity> getAllAdmins() throws RecordNotFoundException;

	AdminEntity logout(AdminEntity admin) throws RecordNotFoundException;    
    
}