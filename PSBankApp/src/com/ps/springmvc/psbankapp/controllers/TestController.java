package com.ps.springmvc.psbankapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value= {"","/","/index","/index*","/views/*"})
 public String testController() {
		return "testctrl";
		
 }
@RequestMapping(value="/name")
public String methodWithParam(@RequestParam(value="userName",required=false,defaultValue="Guest")String userName,Model model) {
	System.out.println("Page requested by" + userName);
	model.addAttribute("usrname",userName);
	return "testRequestMapping";
}
@RequestMapping(value="/dynamic/{category:[a-z]+}/{userName}")
public String dynamicUrl(@PathVariable("userName") String userName ){
	
	return "testRequestMapping";
}
@RequestMapping("*")
public String errorPage() {
	return "fileNotFound";
	
}
}

