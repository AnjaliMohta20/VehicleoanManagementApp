package com.appvehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.InvalidDetailsException;
import com.appvehicle.exceptions.LoanApplicationException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.ApprovedLoansEntity;
import com.appvehicle.service.ApprovedLoanServiceImpl;
 

@Controller
@RequestMapping("/api/vehicleloans")
public class ApprovedLoanController 
{
 
    
    @Autowired
    private ApprovedLoanServiceImpl approvedLoanService;
    
    //GET APPROVED DETAILS BY EMAIL
    @GetMapping("/approvedloans/{email}")  
    public ResponseEntity<List<ApprovedLoansEntity>> showAllApprovedByEmail(@PathVariable("email") String email) throws RecordNotFoundException
    {
        
        List<ApprovedLoansEntity> approvedLoans = approvedLoanService.showAllApprovedByEmail(email);
        return new ResponseEntity<List<ApprovedLoansEntity>>(approvedLoans, HttpStatus.OK);
        
    }
    
    //SHOW APPROVED DETAILS BY LOANID
    @GetMapping("/approvedloans/{aId}")
    public ResponseEntity<ApprovedLoansEntity> showApprovedByLoanId(@PathVariable("aId") int loanId) throws RecordNotFoundException
    {
        
        ApprovedLoansEntity approvedLoans = approvedLoanService.showApprovedByLoanId(loanId);
        return new ResponseEntity<ApprovedLoansEntity>(approvedLoans, HttpStatus.OK);
    
    }
    
	 
	 /* controller for adding approved loans */
	
		@PostMapping("/approvedloans")
		public ResponseEntity<List<ApprovedLoansEntity>> addApprovedLoan(
				@RequestBody ApprovedLoansEntity approved) throws DuplicateRecordException, InvalidDetailsException, LoanApplicationException{
			List<ApprovedLoansEntity> approvedLoans= approvedLoanService.addApprovedLoan(approved);
			//log.info("Adding Approved Loans");
			return new ResponseEntity<List<ApprovedLoansEntity>>(approvedLoans, HttpStatus.OK);
		}
		
		@GetMapping("/loans")
		public ResponseEntity<List<ApprovedLoansEntity>> getAllProducts(){ 
			List<ApprovedLoansEntity> approvedLoans= approvedLoanService.showall();
			return new ResponseEntity<List<ApprovedLoansEntity>>(approvedLoans, HttpStatus.OK);
		}
	 	
 
}
 