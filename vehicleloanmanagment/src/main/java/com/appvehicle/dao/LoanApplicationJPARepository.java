package com.appvehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.appvehicle.model.LoanApplicationEntity;

@RepositoryRestResource(collectionResourceRel = "loanApplications", path = "loanApplications")
public interface LoanApplicationJPARepository extends JpaRepository<LoanApplicationEntity, String> {

	@Query("Select l FROM LoanApplicationEntity l where l.user.userId=(select u.userdetails.userId from UserRegistrationEntity u where u.email=:mail)")
	public List<LoanApplicationEntity> showAllLoanApplicationByEmail(@Param("mail") String email);

	@Query("Select l FROM LoanApplicationEntity l where l.status='Rejected' and l.user.userId=(select u.userdetails.userId from UserRegistrationEntity u where u.email =:em)")
	public List<LoanApplicationEntity> showAllRejectedLoansByEmail(@Param("em") String email);

	@Query("Select loans FROM LoanApplicationEntity loans where loans.status='Pending'")
	public List<LoanApplicationEntity> showAllPendingLoans();

	@Query("Select loans FROM LoanApplicationEntity loans where loans.status='Rejected'")
	public List<LoanApplicationEntity> showAllRejectedLoans();

	@Query("Select loans FROM LoanApplicationEntity loans where loans.status='Accepted'")
	public List<LoanApplicationEntity> showAllAcceptedLoans();

}
