package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showTheForm() {
		return "helloworld-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processTheForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String studentName = request.getParameter("studentName");
		String result = "Yo! " + studentName.toUpperCase();
		model.addAttribute("message", result);
		return "helloworld";
	}

	
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDudeVersionTwo(@RequestParam("studentName") String studentName, Model model) {
		String result = "Hey Man from V3! " + studentName.toUpperCase();
		model.addAttribute("message", result);
		return "helloworld";
	}

}
