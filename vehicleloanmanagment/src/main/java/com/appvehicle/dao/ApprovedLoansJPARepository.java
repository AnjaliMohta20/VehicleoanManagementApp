package com.appvehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.appvehicle.model.ApprovedLoansEntity;


@RepositoryRestResource(collectionResourceRel="approvedLoans",path="approvedLoans")
public interface ApprovedLoansJPARepository extends JpaRepository<ApprovedLoansEntity,Integer> {

@Query("SELECT a FROM ApprovedLoansEntity a WHERE a.account.accountNo = (SELECT acc.accountNo FROM AccountEntity acc WHERE acc.user.userId = (SELECT u.userdetails.userId FROM UserRegistrationEntity u WHERE u.email =:mail))") 
public List<ApprovedLoansEntity> showAllApprovedByEmail(@Param("mail") String email);
}
