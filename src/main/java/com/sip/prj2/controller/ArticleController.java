package com.sip.prj2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.prj2.entities.Article;
import com.sip.prj2.forms.ArticleForm;

@Controller
public class ArticleController {

	public static ArrayList<Article> articles = new ArrayList<Article>();
	
	static {
		articles.add(new Article("Book","10"));
		articles.add(new Article("Laptop","2000"));
		articles.add(new Article("pen","1"));
		
	}
	
	@Value("${error.message}")
	private String errormsg;   
	
	
	@GetMapping("/")
	public String redirect() {

		return "/home";
	}
	
	@GetMapping("/articlelist")
	public String articlelist(Model model) {
		
		model.addAttribute("articles",articles);
		return "/articlelist";
	} 
	
	@GetMapping("/addarticle")
	public String getarticle(Model model){
		ArticleForm articleform = new ArticleForm();
		model.addAttribute("articleform",articleform);
		return "/addarticle";
		
	}
	
	@PostMapping("/addarticle")
	public String postarticle(Model model,@ModelAttribute ("articleform") ArticleForm articleform) {
		String label = articleform.getLabel();
		String price = articleform.getPrice();
		
		if(label!=null && label.length()>0 && price != null && price.length()>0) {
			articles.add(new Article(label,price));
			return "redirect:/articlelist";
		}
		
		model.addAttribute("errormsg",errormsg);
		return "/addarticle";
	}
	
	
}












