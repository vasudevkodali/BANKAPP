package com.ps.springmvc.psbankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.springmvc.psbankapp.model.Account;
import com.ps.springmvc.psbankapp.services.AccountService;

@RestController
@RequestMapping(value="/account")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ResponseEntity<Account> getAccount(@RequestBody Account accnt) {
		System.out.println("Requested Account Number:"+accnt.getAccountNo()); 
		Account account=accountService.getAccount(Integer.parseInt(accnt.getAccountNo()));
		if(account==null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Account>(account,HttpStatus.OK);
		
	}

}
