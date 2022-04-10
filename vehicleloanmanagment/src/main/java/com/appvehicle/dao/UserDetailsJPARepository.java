package com.appvehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.appvehicle.model.UserDetailsEntity;



@RepositoryRestResource(collectionResourceRel="userDetails",path="userDetails")
public interface UserDetailsJPARepository extends JpaRepository<UserDetailsEntity,Integer> {
    
	//public UserDetailsEntity findByEmail(@Param("email") String email);
}
