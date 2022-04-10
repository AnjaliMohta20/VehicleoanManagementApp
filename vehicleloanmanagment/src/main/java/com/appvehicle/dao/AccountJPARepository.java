package com.appvehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.appvehicle.model.AccountEntity;

@RepositoryRestResource(collectionResourceRel="accounts",path="accounts")
public interface AccountJPARepository extends JpaRepository<AccountEntity,Integer> {
	//@Query("Select account FROM AccountEntity account, ApprovedLoansEntity approved where approved.getAccount().getAccountNo()=account.getAccountNo() and approved.getLoanId()=:loanId")
	//public AccountEntity getAccountByLoanId(@Param("loanId") int loanId);

	@Query("Select a from AccountEntity a where a.user.userId=(Select u.userdetails.userId from UserRegistrationEntity u where u.email=:email)")
    //@Query("Select account FROM AccountEntity account, ApprovedLoansEntity approved where approved.getAccount().getAccountNo()=account.getAccountNo() and approved.getLoanId()=:loanId")
    public AccountEntity getByEmail(@Param("email") String email);




}
