package com.appvehicle.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.AccountEntity;
import com.appvehicle.service.AccountServiceImpl;

 

@Controller
@RequestMapping("/api/vehicleloans")
@ComponentScan("com.appvehicle")
public class AccountController {
    @Autowired
    private AccountServiceImpl Service;    
    @GetMapping(value="/hi")
    public String sayHello() {
        System.out.println("heelo........");
        return "account";
    }
    @GetMapping("/accounts/{email}")
    public ResponseEntity<AccountEntity> findAccount( @PathVariable("email")String email) throws RecordNotFoundException{
        AccountEntity accounts= Service.getAccountByEmail(email);
        return new ResponseEntity<AccountEntity>(accounts, HttpStatus.OK);
        
    }
    @PostMapping("/accounts")
    public ResponseEntity<List<AccountEntity>> insertAccount( @RequestBody @Valid AccountEntity account) throws RecordNotFoundException{
        List<AccountEntity> accounts=Service.AddAccount(account);
        return new ResponseEntity<List<AccountEntity>>(accounts, HttpStatus.OK);
    }
    
    @PutMapping("/accounts/{accountNo}")
   public ResponseEntity<List<AccountEntity>> updateAccount(@PathVariable("accountNo")@RequestBody AccountEntity account) throws RecordNotFoundException{
        List<AccountEntity> accounts= Service.UpdateAccount(account);
        return new ResponseEntity<List<AccountEntity>>(accounts, HttpStatus.OK);
    }
    
}
 