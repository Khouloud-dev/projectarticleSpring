package com.sip.prj2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sip.prj2.entities.Article;
import com.sip.prj2.entities.Provider;
import com.sip.prj2.forms.ArticleForm;
import com.sip.prj2.forms.ProviderForm;


@Controller
public class ProviderController {

	public static ArrayList<Provider> providers = new ArrayList<Provider>();
	
	
	static {
		providers.add(new Provider("Alex","adress1","alex@gmail.com"));
		providers.add(new Provider("Caroline","adress2","caroline@gmail.com"));
		providers.add(new Provider("Michel","adress3","michel@gmail.com"));
	}
	
	@Value("${error.message}")
	private String errormsg;
	
	@GetMapping("/providerlist")
	public String getproviderlist(Model model) {
		model.addAttribute("providers",providers);
		return "/providerlist";
		
	} 
	
	@GetMapping("/addprovider")
	public String getprovider(Model model) {
		ProviderForm providerform = new ProviderForm();
		model.addAttribute("providerform",providerform);
		return "/addprovider";
		
	} 
	
	@PostMapping("/addprovider")
	public String postprovider(Model model,@ModelAttribute ("providerform") ProviderForm providerform) {
		String name = providerform.getName();
		String adress = providerform.getAdress();
		String email = providerform.getEmail();
		if(name!=null && name.length()>0 && adress!=null && adress.length()>0 && email!=null && email.length()>0) {
			providers.add(new Provider(name,adress,email));
			return "redirect:/providerlist";
		}
		
		model.addAttribute("errormsg",errormsg);
		return "/addprovider";
	}
}
















