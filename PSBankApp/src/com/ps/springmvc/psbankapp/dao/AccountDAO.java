package com.ps.springmvc.psbankapp.dao;

import java.util.List;

import com.ps.springmvc.psbankapp.model.Account;

public interface AccountDAO {
   public boolean saveAccount(Account account);
   
   public List<Account> getAccount();
   
   public Account getAccount(Integer accountNo);

public boolean deleteAccount(Integer accountNo);

}
