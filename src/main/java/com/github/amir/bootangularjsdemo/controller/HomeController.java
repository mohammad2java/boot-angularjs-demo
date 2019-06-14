package com.github.amir.bootangularjsdemo.controller;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.amir.bootangularjsdemo.controller.model.Formdata;
import com.github.amir.bootangularjsdemo.controller.model.FormdataValidator;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHomePage() {
		return "/app/view/index";
	}
	

	@GetMapping("/thymeleaf")
	public String getThymeleafHomePage(ModelMap map) {
		map.put("thy_hello", "java-object-welcome to thymeleaf");
		map.put("formdata", new Formdata());
		List<String> countries = Arrays.asList("india","pakistan","iran");
		map.put("countries",countries);
		return "/app/view/thymeleaf_basic";
		
	}

	@PostMapping("/thymeleafsave")
	public String saveThymeleafHomePage(@Valid Formdata formdata,BindingResult bindingResult,ModelMap map) {
		map.put("thy_hello", "java-object-welcome to thymeleaf");
		map.put("formdata", formdata);
		new FormdataValidator().validate(formdata, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/app/view/thymeleaf_basic";
		}
		return "/app/view/thymeleaf_useradd";
	}

}
