package com.appvehicle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.InvalidDetailsException;
import com.appvehicle.exceptions.LoanApplicationException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.ApprovedLoansEntity;

@Service
public interface ApprovedLoanService 
{
 
    //GET APPROVED BY EMAIL
    public List<ApprovedLoansEntity> showAllApprovedByEmail(String email) throws RecordNotFoundException;
    
    //GET APPROVED BY LOANID
    public ApprovedLoansEntity showApprovedByLoanId(int loanId) throws RecordNotFoundException;
    
    //Saranya
    public List<ApprovedLoansEntity> addApprovedLoan(ApprovedLoansEntity approved) throws RecordNotFoundException, DuplicateRecordException, InvalidDetailsException, LoanApplicationException;

	List<ApprovedLoansEntity> showall();
 
     
}