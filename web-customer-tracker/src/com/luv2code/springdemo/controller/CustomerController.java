package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDaoImpl;
	
	@GetMapping("/list")
	public String getListOfCustomer(Model model) {

		List<Customer> customers = customerDaoImpl.getAllCustomers();
		model.addAttribute("customers", customers);
		return "list-Customers";
	}
}