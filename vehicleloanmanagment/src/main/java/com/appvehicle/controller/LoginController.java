package com.appvehicle.controller;
//import com.cg.model.Product;
//import com.cg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.DuplicateRecordException;
import com.appvehicle.exceptions.InvalidDetailsException;
import com.appvehicle.exceptions.LoanApplicationException;
import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.exceptions.RegistrationException;
import com.appvehicle.model.AdminEntity;
import com.appvehicle.model.ApprovedLoansEntity;
import com.appvehicle.model.LoanApplicationEntity;
import com.appvehicle.model.UserDetailsEntity;
import com.appvehicle.model.UserRegistrationEntity;
import com.appvehicle.service.LoginDtoServiceImpl;
@Controller
@RequestMapping("/api/vehicleloans")
public class LoginController {
	@Autowired
	LoginDtoServiceImpl loginService;
	
	@GetMapping("/userlogin/{userEmail}/{password}")
	public String  verifyUser(
		@PathVariable ("userEmail") String userEmail, @PathVariable("password")String password) throws RegistrationException, RecordNotFoundException, DuplicateRecordException{
			 // String userEmail, String password) throws RegistrationException, RecordNotFoundException, DuplicateRecordException{

		  UserRegistrationEntity retUser = loginService.authenticateUser(userEmail, password);
		  //Log.info(" user signing");
		  EntityModel<UserRegistrationEntity> resource=EntityModel.of(retUser);
//		  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegisterController.class).passwordReset(new UserRegistrationEntity())).withRel("change the password"));
//	     resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegisterController.class).showUserRegistrationInformation("")).withRel("view Registration details"));
//		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsController.class).findUser(0)).withRel("view user details"));
//		 //resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsController.class).updateUser(new UserDetailsEntity())).withRel("update the details"));
//		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsController.class).addUserDetails(" ",new UserDetailsEntity())).withRel("insert the user details"));
//		 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class).applyLoan(new LoanApplicationEntity(),0)).withRel("apply for the loan"));
//		  return new ResponseEntity<Object>(resource , HttpStatus.OK); 
		  return "userservices";
	}
	
	
	@GetMapping("/adminlogin/{adminEmail}/{password}") 
	public ResponseEntity<Object> adminVerfication(
			String adminEmail,String password) throws RegistrationException, RecordNotFoundException, DuplicateRecordException, InvalidDetailsException, LoanApplicationException{
			AdminEntity admin= loginService.authenticateAdmin(adminEmail, password);//Log.info("admin sign in");
			EntityModel<AdminEntity> resource=EntityModel.of(admin);
//			 resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class).updateLoanApplication(new LoanApplicationEntity())).withRel("update the loan application"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class).getAllPendingLoans()).withRel("view all pending loans"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).addApprovedLoan(new ApprovedLoansEntity())).withRel("approve an account"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LoanApplicationController.class).getAllApprovedLoans()).withRel("view all accepted loans"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserDetailsController.class).findUser(0)).withRel("view user details by Id"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).showAllApprovedByEmail("")).withRel("view all approved loans by email"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRegisterController.class).getAllUsers()).withRel("view all registerd users"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).showApprovedByLoanId(0)).withRel("view approved loan by id"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ApprovedLoanController.class).getAllProducts()).withRel("view all accounts"));
//			  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AdminController.class).updateAdmin(new AdminEntity())).withRel("update the admin detailsgfhj"));
			  return new ResponseEntity<Object>(resource,HttpStatus.OK);
	}

}