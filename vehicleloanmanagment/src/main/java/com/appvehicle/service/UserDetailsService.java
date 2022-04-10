package com.appvehicle.service;





import java.util.List;

import org.springframework.stereotype.Service;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.UserDetailsEntity;
@Service
public interface UserDetailsService 
{
    public List<UserDetailsEntity> addUserDetails(UserDetailsEntity useradvanced, String email) throws RecordNotFoundException;//userDao
    public UserDetailsEntity showUserDetailsInformationByUserId(int userId) throws RecordNotFoundException;//userDao
    public List<UserDetailsEntity> editUserDetails(UserDetailsEntity user) throws RecordNotFoundException;//userDao
    public List<UserDetailsEntity> showAllUserDetails() throws RecordNotFoundException;//adminDao
    
    
    
}