package com.appvehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appvehicle.dao.LoanApplicationJPARepository;
import com.appvehicle.dao.UserDetailsJPARepository;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.LoanApplicationEntity;
import com.appvehicle.model.UserDetailsEntity;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	private LoanApplicationJPARepository loansRepo;
	@Autowired
	private UserDetailsJPARepository userDetailsRepo;

	// Get all loan applications of a user using email
	@Override
	public List<LoanApplicationEntity> showAllLoanApplicationByEmail(String email) throws RecordNotFoundException {
		// TODO Auto-generated method stub

		if (email == null) {
			throw new RecordNotFoundException("Null Email Entered");
		}
		List<LoanApplicationEntity> loansApp = loansRepo.showAllLoanApplicationByEmail(email);

		if (loansApp.isEmpty())
			throw new RecordNotFoundException("No loans applied");
		return loansApp;
	}

	// Get all Rejected loans of a user using email
	@Override
	public List<LoanApplicationEntity> showRejectedLoansByEmail(String email) throws RecordNotFoundException {
		if (email == null) {
			throw new RecordNotFoundException("Null Email Entered");
		}
		List<LoanApplicationEntity> loansApp = loansRepo.showAllRejectedLoansByEmail(email);
		if (loansApp.isEmpty())
			throw new RecordNotFoundException("No Rejected loans found");
		return loansApp;
	}

	// Modify Loan Application Status
	@Override
	public List<LoanApplicationEntity> modifyLoanApplicationStatus(LoanApplicationEntity loanApp)
			throws RecordNotFoundException {

		if (loanApp == null) {
			throw new RecordNotFoundException("Loan Application Not Found");
		} else if ((loansRepo.findById(loanApp.getChassisNo())) != null) {
			double sal = loanApp.getUser().getSalary();

			if (loanApp.getAmount() < sal * 2
					|| (loanApp.getExistingEMI() < (loanApp.getAmount() / (loanApp.getTenure() * 12)))) {
				loanApp.setStatus("Approved");
				loansRepo.save(loanApp);
			} else {
				loanApp.setStatus("Rejected");
				loansRepo.save(loanApp);
			}
		}
		return loansRepo.findAll();

	}

	// Apply for a loan
	@Override
	public Optional<List<LoanApplicationEntity>> applyLoan(LoanApplicationEntity loanApp, int userId) {

		if (loanApp == null) {
			return null;
		} else {
			Optional<UserDetailsEntity> user = userDetailsRepo.findById(userId);
			
			loanApp.setUser(user.get());
			if (loanApp.getStatus().equalsIgnoreCase("pending") )
				loansRepo.saveAndFlush(loanApp);
			return Optional.of(loansRepo.findAll());
		}
	}

	// Show loan application by chassis number
	@Override
	public Optional<LoanApplicationEntity> showLoanApplicationByChassis(String chassisNo)
			throws RecordNotFoundException {

		if (chassisNo == null) {
			throw new RecordNotFoundException("Null chassis number Entered");
		}
		// TODO Auto-generated method stub
		Optional<LoanApplicationEntity> loanApp = loansRepo.findById(chassisNo);
		if (loanApp == null)
			throw new RecordNotFoundException("Loan Application Not Found");

		return loanApp;
	}

	// Show all Loan Applications
	@Override
	public List<LoanApplicationEntity> showAllLoanApplications() throws RecordNotFoundException {
		// TODO Auto-generated method stub
		if (loansRepo.findAll().isEmpty())
			throw new RecordNotFoundException("No Loan Applications available");
		return loansRepo.findAll();

	}

	/* Method to show all Pending Users */
	@Override
	public List<LoanApplicationEntity> getAllPendingLoans() throws RecordNotFoundException {
		List<LoanApplicationEntity> pendingLoans = loansRepo.showAllPendingLoans();
		if (pendingLoans.isEmpty())
			throw new RecordNotFoundException("No Pending Loans");
		else
			return pendingLoans;
	}

	/* Method to show all Rejected loans */

	@Override
	public List<LoanApplicationEntity> getAllRejectedLoans() throws RecordNotFoundException {
		List<LoanApplicationEntity> rejectedLoans = loansRepo.showAllRejectedLoans();
		if (rejectedLoans.isEmpty())
			throw new RecordNotFoundException("No Rejected Loans");
		else
			return rejectedLoans;
	}

	/* Method to show all Accepted Loans */

	@Override
	public List<LoanApplicationEntity> getAllAcceptedLoans() throws RecordNotFoundException {

		List<LoanApplicationEntity> approveLoans = loansRepo.showAllAcceptedLoans();
		if (approveLoans.isEmpty())
			throw new RecordNotFoundException("No Approved Loans");
		else
			return approveLoans;
	}
}
