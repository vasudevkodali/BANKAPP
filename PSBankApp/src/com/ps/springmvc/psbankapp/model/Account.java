package com.ps.springmvc.psbankapp.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ps.springmvc.psbankapp.validations.PSCode;

public class Account {
	
	@NotNull(message="Acount no. cant be empty")
	public String accountNo;
	
	@NotNull
	public String accountHolderName;
		
	@Size(min=2,max=50,message="enter gender")
	public String gender;
	
	@Size(min=2,max=50,message="Invalid adhaar")
	@NotNull(message="AdhaarId can't be empty")
	public String adhaarId;
	
	
	@NotNull(message="Plz enter age")
	public String age;
	
	@NotNull(message="Plz enter min balance")
	public int balance;
	
	@NotNull(message="Address can't be empty")
	@Size(min=2,max=50,message="Invalid lenght of address")
	public String address;
	
	@NotNull
	private String accountType;
	
	@NotNull(message="Enter bank code")
	@PSCode
	private String vkCode;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="Enter date of birth")
	@Past(message="Invalid DOB")
	private Date dateOfBirth;
	
	//setters and getters
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getVkCode() {
		return vkCode;
	}
	public void setVkCode(String vkCode) {
		this.vkCode = vkCode;
	}
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public Account() {
		accountHolderName="";
		gender="";
		adhaarId="";
		age="";
		address="";
		accountType="";
		vkCode="";
		
		
	}
	public Account(String accountHolderName,String adhaarId,String age,String address,String gender,Date dob,String accountType,String vkCode) {
		this.accountHolderName=accountHolderName;
		this.adhaarId=adhaarId;
		this.age=age;
		this.address=address;
		this.gender=gender;
		this.dateOfBirth=dob;
		this.accountType=accountType;
		
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAdhaarId() {
		return adhaarId;
	}
	public void setAdhaarId(String adhaarId) {
		this.adhaarId = adhaarId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
