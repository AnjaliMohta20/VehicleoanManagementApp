package com.appvehicle.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.LoanApplicationEntity;
import com.appvehicle.service.LoanApplicationServiceImpl;

@Controller
@RequestMapping("/api/vehicleloans")
@Validated
public class LoanApplicationController {
	@Autowired
	private LoanApplicationServiceImpl loansAppService;

	public static Logger log = Logger.getLogger(LoanApplicationController.class.getName());

//Get laon applications by email
	@GetMapping("/loanapplications/bymail/{email}")
	public ResponseEntity<List<LoanApplicationEntity>> showLoanApplicationByEmail(
			@PathVariable("email") @Email(message = "email not valid") @NotNull(message = "email null") String email)
			throws RecordNotFoundException {
		log.info("Show Loan Application by Email Start");
		List<LoanApplicationEntity> loansApplied = loansAppService.showAllLoanApplicationByEmail(email);

		if (loansApplied.isEmpty()) {
			throw new RecordNotFoundException("No Loans found");

		}
		log.info("Show Loan Application by Email End");

		return new ResponseEntity<List<LoanApplicationEntity>>(loansApplied, HttpStatus.OK);

	}

//Get loan applications by chassis number
	@GetMapping("/loanapplications/{chassisno}")
	public ResponseEntity<Optional<LoanApplicationEntity>> showLoanApplicationByChassis(
			@PathVariable("chassisno") @Size(min=3,max=20 ,message = "size of chassis number should be min 3 and max 20") String chassisNo)
			throws RecordNotFoundException {
		log.info("Show Loan Application by Chassis number start");
		Optional<LoanApplicationEntity> loansApplied = loansAppService.showLoanApplicationByChassis(chassisNo);
		if (loansApplied == null) {
			throw new RecordNotFoundException("No Loans found");
		}
		log.info("Show Loan Application by Chassis number end");
		return new ResponseEntity<Optional<LoanApplicationEntity>>(loansApplied, HttpStatus.OK);

	}

//Get rejected loans by email
	@GetMapping("/loanapplications/rejected/{email}")
	public ResponseEntity<List<LoanApplicationEntity>> RejectedLoansByEmail(
			@PathVariable("email") @Email(message = "email not valid") @NotNull(message = "email null") String email)
			throws RecordNotFoundException {
		log.info("Show Rejected Loan Applications by email start");
		List<LoanApplicationEntity> loansApplied = loansAppService.showRejectedLoansByEmail(email);
		if (loansApplied.isEmpty()) {
			throw new RecordNotFoundException("No rejected Loans found");
		}
		log.info("Show Rejected Loan Applications by email end");
		return new ResponseEntity<List<LoanApplicationEntity>>(loansApplied, HttpStatus.OK);}

//apply for a loan
		@PostMapping("/loanapplications/{userId}")
		public ResponseEntity<Optional<List<LoanApplicationEntity>>> applyLoan(@Valid @RequestBody LoanApplicationEntity loans,
				@PathVariable("userId") @Min(1) int id)
				throws DuplicateRecordException, RecordNotFoundException {
			log.info("Apply loan start");
			Optional<List<LoanApplicationEntity>> loansApplied = null;
			if ((loansAppService.showLoanApplicationByChassis(loans.getChassisNo())).isPresent())
				throw new DuplicateRecordException("Record already exists");
			else
				loansApplied = loansAppService.applyLoan(loans, id);
			log.info("Apply loan end");
			return new ResponseEntity<Optional<List<LoanApplicationEntity>>>(loansApplied, HttpStatus.OK);
		}
//Modify loan application status
	@PutMapping("/loanapplications")
	public ResponseEntity<List<LoanApplicationEntity>> updateLoanApplication(@Valid @RequestBody LoanApplicationEntity loanApp)
			throws RecordNotFoundException {
		log.info("Update Loan Application start");

		List<LoanApplicationEntity> loans = loansAppService.modifyLoanApplicationStatus(loanApp);

		if (loans.isEmpty()) {
			throw new RecordNotFoundException("Loan not found");
		}
		log.info("Update Loan Application end");
		return new ResponseEntity<List<LoanApplicationEntity>>(loans, HttpStatus.OK);
	}

	/* controller for checking all pending loans */

	@GetMapping("/loanapplications/pendingloans")
	public ResponseEntity<List<LoanApplicationEntity>> getAllPendingLoans() throws RecordNotFoundException {
		List<LoanApplicationEntity> loanApplications = loansAppService.getAllPendingLoans();
		log.info("Show All Pending Loan Applications");

		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}

	/* controller for checking rejected loans */
	@GetMapping("/loanapplications/rejectedloans")
	public ResponseEntity<List<LoanApplicationEntity>> getAllRejectedLoans() throws RecordNotFoundException {
		List<LoanApplicationEntity> loanApplications = loansAppService.getAllRejectedLoans();
		log.info("Show All Rejected Loan Applications");

		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}
	/* controller for checking approved loans */

	@GetMapping("/loanapplications/approvedloans")
	public ResponseEntity<List<LoanApplicationEntity>> getAllApprovedLoans() throws RecordNotFoundException {

		List<LoanApplicationEntity> loanApplications = loansAppService.getAllAcceptedLoans();
		log.info("Show All Accepted Loan Applications");

		return new ResponseEntity<List<LoanApplicationEntity>>(loanApplications, HttpStatus.OK);
	}
}
