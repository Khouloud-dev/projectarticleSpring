package com.sip.prj2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sip.prj2.entities.User;
import com.sip.prj2.forms.UserForm;

@Controller
public class UserController {

   private static  ArrayList<User> users = new ArrayList<User>();
   
   static {
	   users.add(new User("Admin","123"));
	   users.add(new User("Client","1234"));
   }
   
   @Value("${error.message}")
   private String errormsg;
   
   
   @GetMapping("/userlist")
   public String getUser(Model model) {
	   model.addAttribute("users",users);
	   return "/userlist";
   }
   
   @GetMapping("/adduser")
   public String postUser(Model model) {
	   
	   UserForm userform = new UserForm();
	   model.addAttribute("userform",userform);
	   return "/adduser";
   }
   
   @PostMapping("/adduser")
   public String adduser(Model model,@ModelAttribute ("userform") UserForm userform){

		  String userName = userform.getUserName();
		  String passWord = userform.getPassWord();
		  
	  if(userName != null && userName.length()>0 && passWord != null && passWord.length()>0) {
		  users.add(new User(userName,passWord));
		  return "redirect:/userlist";
	  }
	  
      model.addAttribute("errormsg",errormsg);
	  return "/adduser";
   }
   
	
}








