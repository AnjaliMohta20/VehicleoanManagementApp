package com.appvehicle.service;
 
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appvehicle.dao.AdminJPARepository;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.AdminEntity;
 

@Service
public class AdminServiceImpl implements AdminService 
{
 

    static Logger log = Logger.getLogger(AdminServiceImpl.class.getClass());
 
    @Autowired
    private AdminJPARepository adminRepo;
 
    //ADDING AN ADMIN
    @Override
    public AdminEntity adminRegister(AdminEntity admin) throws RecordNotFoundException
    {
 
        log.info("Service Layer - Entry - adminRegister");
      
        AdminEntity adminEntity = new AdminEntity();
        if(admin.getEmail().isEmpty() && admin.getName().isEmpty() && admin.getPassword().isEmpty())
        {
            log.warn("WARN: Admin details Should not be empty");
            throw new RecordNotFoundException("Admin details should not be null");
        }
        log.info("Service Layer - Exit - adminRegister");
        adminEntity = adminRepo.saveAndFlush(admin); 
        return adminEntity;
        
    }
 
    //GET ADMIN BY EMAIL
    @Override
    public AdminEntity showAdminDetailsByEmail(String email) throws RecordNotFoundException
    {
 
    	if(email==null) {
    		throw new RecordNotFoundException("Null email entered");
    	}
        log.info("Service Layer - Entry - showAdminDetailsByEmail");
 
        Optional<AdminEntity> admin = adminRepo.findById(email);
 
        if(admin==null)
        {
            log.warn("WARN: Admin Email not found");
            throw new RecordNotFoundException("Admin Email not found");
        }
        log.info("Service Layer - Exit - showAdminDetailsByEmail");
 
        return admin.get();
 
    }
 
    //UPDATING AN ADMIN
    @Override
    public List<AdminEntity> updateAdmin(AdminEntity admin) throws RecordNotFoundException
    {
 
        log.info("Service Layer - Entry - updateAdminByEmail");
 
        if(admin.getEmail().isEmpty())
        {
            log.warn("WARN: Email Should not be empty");
            throw new RecordNotFoundException("Admin Email not found");
        }
        log.info("Service Layer - Exit - updateAdminByEmail");
        adminRepo.save(admin);
        return adminRepo.findAll();
        
    }
    
   // USED TO LOGOUT
	@Override
    public AdminEntity logout(AdminEntity admin)throws RecordNotFoundException {
        // TODO Auto-generated method stub
        Optional<AdminEntity> ad =adminRepo.findById(admin.getEmail());
        if (admin.getEmail().equals(ad.get().getEmail()))
        {
            return ad.get();
        } else
            return null;



    }
 
    //GET ALL ADMINS
    @Override
    public List<AdminEntity> getAllAdmins() throws RecordNotFoundException 
    {
            return adminRepo.findAll();
            
    }

}