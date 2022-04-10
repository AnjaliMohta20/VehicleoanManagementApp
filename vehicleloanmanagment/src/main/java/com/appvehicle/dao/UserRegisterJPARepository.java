package com.appvehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.appvehicle.model.UserRegistrationEntity;



@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRegisterJPARepository extends JpaRepository<UserRegistrationEntity,String> {

}


	
