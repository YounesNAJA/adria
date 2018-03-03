package com.younesnaja.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
//		try {
//			String phyPath = request.getSession().getServletContext().getRealPath("/");
//
//			String filepath = phyPath + "resources/Persons.txt";
//			File file = new File(filepath);
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return "home";
	}

}