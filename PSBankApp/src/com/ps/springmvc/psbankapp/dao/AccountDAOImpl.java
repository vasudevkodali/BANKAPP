package com.ps.springmvc.psbankapp.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankapp.entity.AccountEntity;
import com.ps.springmvc.psbankapp.model.Account;


@Repository
public class AccountDAOImpl implements AccountDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAccount(Account account) {
		
		boolean saveFlag=true;
		AccountEntity accountEntity =new AccountEntity();
		accountEntity.setAccNo(account.getAccountNo());
		accountEntity.setAccHolderName(account.getAccountHolderName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setPsCode(account.getVkCode());
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(accountEntity);
			//currentSession.saveOrUpdate(accountEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
			saveFlag=false;
		}		
		
		return saveFlag;
	}

	@Override
	public List<Account> getAccount() {
		List<Account> list=new ArrayList<Account>();
		try {
			Session session=sessionFactory.getCurrentSession();
			Query<AccountEntity> query=session.createQuery("From AccountEntity",AccountEntity.class);
			List<AccountEntity> accounts=query.getResultList();
			for(int i=0;i<accounts.size();i++) {
				AccountEntity accountEntity=(AccountEntity)accounts.get(i);
				Account account=new Account();
				account.setAccountNo(accountEntity.getAccNo());
				account.setAccountHolderName(accountEntity.getAccHolderName());
				account.setBalance(accountEntity.getBalance());
				account.setAccountType(accountEntity.getAccountType());
				account.setDateOfBirth(accountEntity.getDateOfBirth());
				account.setVkCode(accountEntity.getPsCode());
				list.add(account);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Account getAccount(Integer accountNo) {
		// TODO Auto-generated method stub
		Account account=new Account();
		try {
		Session session=sessionFactory.getCurrentSession();
		AccountEntity accountEntity=(AccountEntity) session.get(AccountEntity.class,Integer.toString(accountNo));
		if(accountEntity==null) {
			return null;
		}
		
		account.setAccountNo(accountEntity.getAccNo());
		account.setAccountHolderName(accountEntity.getAccHolderName());
		account.setBalance(accountEntity.getBalance());
		account.setAccountType(accountEntity.getAccountType());
		account.setDateOfBirth(accountEntity.getDateOfBirth());
		account.setVkCode(accountEntity.getPsCode());
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return account;
	}

	@Override
	public boolean deleteAccount(Integer accountNo) {
		boolean deleteFlag=true;
		try {
			Session session=sessionFactory.getCurrentSession();
			AccountEntity accountEntity=(AccountEntity) session.load(AccountEntity.class,Integer.toString(accountNo));
			session.delete(accountEntity);
		} catch (Exception ex) {
			deleteFlag=false;
			ex.printStackTrace();
		}
		return deleteFlag;
	}

	

}