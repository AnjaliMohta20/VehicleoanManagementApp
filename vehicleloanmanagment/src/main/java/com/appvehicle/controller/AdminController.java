package com.appvehicle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.AdminEntity;
import com.appvehicle.service.AdminServiceImpl;
 

@Controller
@RequestMapping("/api/vehicleloans")
public class AdminController 
{
    
    @Autowired
    private AdminServiceImpl adminService;
    
  //ADDING AN ADMIN
  @PostMapping("/admin/r")
  public ResponseEntity<AdminEntity> adminRegister(@Valid AdminEntity admin) throws RecordNotFoundException
  {
  AdminEntity adminEntity = adminService.adminRegister(admin);
  return new ResponseEntity<AdminEntity>(adminEntity, HttpStatus.OK);
  }


    
    //GET ADMIN BY EMAIL
    
    @GetMapping("/admin/{adminEmailId}")
    public ResponseEntity<AdminEntity> showAdminDetailsByEmail(@PathVariable("adminEmailId") String mail) throws RecordNotFoundException {
        
        AdminEntity adminEntity = adminService.showAdminDetailsByEmail(mail);
        return new ResponseEntity<AdminEntity>(adminEntity,HttpStatus.OK);
        
 }
    
    //UPDATING AN ADMIN
    @PutMapping("/admin​​")
    public ResponseEntity<List<AdminEntity>> updateAdmin(@Valid AdminEntity admin) throws RecordNotFoundException
    {
        
        List<AdminEntity> adminEntity = adminService.updateAdmin(admin);
        return new ResponseEntity<List<AdminEntity>>(adminEntity, HttpStatus.OK);
        
    }
    
    //GET ALL ADMINS
    @GetMapping("/admin")
    public ResponseEntity<List<AdminEntity>> getAllAdmins() throws RecordNotFoundException{
        
        List<AdminEntity> adminEntity = adminService.getAllAdmins();
        return new ResponseEntity<List<AdminEntity>>(adminEntity, HttpStatus.OK);
    }
    
    //USED TO LOGOUT
    @PostMapping("/admin/logout")
    public ResponseEntity<String> logout(@RequestBody AdminEntity admin) throws RecordNotFoundException{
        
        return new ResponseEntity("Logout Successful", HttpStatus.OK);

    }
}