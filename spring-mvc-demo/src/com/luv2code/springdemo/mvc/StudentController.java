package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String showStudentForm(@ModelAttribute("student") Student theStudent ) {
		System.out.println("First name 		 : " + theStudent.getFirstName());
		System.out.println("Last name  		 : " + theStudent.getLastName());
	System.out.println("Country    			 : " + theStudent.getCountry());
		System.out.println("Favorite language: " + theStudent.getFavLang());
		return "student-confirmation";
	}
	
}
