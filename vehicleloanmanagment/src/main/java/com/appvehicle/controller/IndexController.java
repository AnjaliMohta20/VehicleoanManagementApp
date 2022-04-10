package com.appvehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("hi");
		return "index";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
	
	@RequestMapping("/loanapplication")
	public String loanapplication() {
		return "loanapplication";
	}
	
	
	@RequestMapping("/applyloan")
	public String applyloan() {
		return "applyloan";
	}
	
	@RequestMapping("/userlogin")
	public String userlogin() {
		return "userlogin";
	}
	
	@RequestMapping("/userdetails")
	public String userdetails() {
		return "userdetails";
	}
//	
//	@RequestMapping("/userser")
//	public String userdetails() {
//		return "userdetails";
//	}
	
	@RequestMapping("/userregister")
	public String userregister() {
		return "userregister";
	}
	
	@RequestMapping("/adduserdetail")
	public String adduserdetail() {
		return "adduserdetail";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	
	@RequestMapping("/adminregister")
	public String adminregister() {
		return "adminregister";
	}
}
