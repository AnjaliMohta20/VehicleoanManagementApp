package com.appvehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.LoanApplicationEntity;

@Service
public interface LoanApplicationService {

	public List<LoanApplicationEntity> showAllLoanApplicationByEmail( String email) throws RecordNotFoundException;	
	
	public List<LoanApplicationEntity> showRejectedLoansByEmail(String email) throws RecordNotFoundException ;
	
	public List<LoanApplicationEntity> modifyLoanApplicationStatus(LoanApplicationEntity loanapp) throws RecordNotFoundException;
	
	public Optional<List<LoanApplicationEntity>> applyLoan(LoanApplicationEntity loanapp,int userId);
	
	public Optional<LoanApplicationEntity> showLoanApplicationByChassis(String chassisNo) throws RecordNotFoundException;
	
	public List<LoanApplicationEntity> showAllLoanApplications() throws RecordNotFoundException;
	
	public List<LoanApplicationEntity> getAllPendingLoans() throws RecordNotFoundException;
	
    public List<LoanApplicationEntity> getAllRejectedLoans() throws RecordNotFoundException;
    
    public List<LoanApplicationEntity> getAllAcceptedLoans() throws RecordNotFoundException;
	
}
