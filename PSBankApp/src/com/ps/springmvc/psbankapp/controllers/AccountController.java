package com.ps.springmvc.psbankapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.springmvc.psbankapp.model.Account;
import com.ps.springmvc.psbankapp.services.AccountService;

@Controller
public class AccountController {
     
	@Autowired
	AccountService accountService;
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,ste);
	}
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
		
	}
	
	@RequestMapping(value="/find" ,method=RequestMethod.GET)
	public String viewAccount(Model model) {
		return "findAccount";
	}
	@RequestMapping("/new")
	public String createAccount(Model model) {
		model.addAttribute("account",new Account());
		return "account-form";
	}
	@RequestMapping("/accDetails")
	public String accDetails() {
		return "details";
	}
	@RequestMapping(value="/showDetails",method=RequestMethod.POST)
	public String showDetails(@Valid @ModelAttribute("account")Account account,BindingResult result,Model model) {
		/*String acName=request.getParameter("accountHolderName");
		String age=(request.getParameter("age"));
		String uid=(request.getParameter("adhaarId"));
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		System.out.println(gender);
		Account account=new Account(acName,uid,age,address,gender);
		model.addAttribute("accoun",acc);*/
		
		/*if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "account-form";
		}
		else
		accountService.saveAccount(account);
		return "redirect:/list";*/
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "account-form";

		}
		else {
			String message="";
			boolean flag=true;
			try {
			
				flag=accountService.saveAccount(account);
			}
			catch(Exception ex) {
				
				message=ex.getMessage();
				flag=false;
			}
			if(!flag) {
				model.addAttribute("message",message);
				return "account-form";
			}
			model.addAttribute("account",account);
			return "redirect:/list";
		}
		
	}
		
	
	@GetMapping("/list")   //GetMapping is short represent for Request mapping with method=get
	public String listAccount(Model model) {
		List<Account> accs=accountService.getAccounts();
		model.addAttribute("accounts",accs);
		Authentication auth=SecurityContextHolder.getContext().getAuthentication(); 
		String name=auth.getName();
		model.addAttribute("username",name);
		return "listAccounts";
	}
	@GetMapping("/edit")
	public String updateAccount(@RequestParam("accountNo")int accountNo,Model model) {
		Account account =accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account",account);
		return "account-form";
	}
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("accountNo")int accountNo,Model model) {
		accountService.deleteAccount(new Integer(accountNo));
		
		return "redirect:/list";
	}
	
	
	
}
