package com.appvehicle.service;
    import java.util.List;

import com.appvehicle.exceptions.RecordNotFoundException;
import com.appvehicle.model.AccountEntity;

 

    public interface AccountService {
    	
        public AccountEntity getAccountByEmail(String email) throws RecordNotFoundException;
        
        public List<AccountEntity> AddAccount(AccountEntity account) throws RecordNotFoundException;
        
        public List<AccountEntity> UpdateAccount(AccountEntity account)throws RecordNotFoundException;
    
    }
 


