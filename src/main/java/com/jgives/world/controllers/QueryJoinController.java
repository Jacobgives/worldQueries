package com.jgives.world.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jgives.world.models.Country;
import com.jgives.world.services.ApiService;

@Controller
public class QueryJoinController {
	
	private ApiService apiService;
	
	public QueryJoinController(ApiService apiService) {
		this.apiService=apiService;
	}
	
	@RequestMapping("/")
	public String index() {
		List<Country> countries = apiService.findCountriesWGovCapGTLEGT("Constitutional Monarchy", 200, 75.0);
		for (Country row : countries) {
			System.out.println("name: "+row.getName());
		}
				
		return "index.jsp";
	}
}
