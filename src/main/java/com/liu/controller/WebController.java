package com.liu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liu.model.PersonForm;
import com.liu.model.PersonForm2;
import com.liu.model.User;

@Controller
@RequestMapping("/web")
public class WebController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/results";
	}

	@GetMapping("/person")
	public String showForm(PersonForm2 person) {
		return "form2";
	}
	
	@PostMapping("/addPerson")
	public String addPerson(@ModelAttribute("person") PersonForm2 person, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",
				"addPerson success: " + person != null ? person.getName() : "" + "!");
		return "redirect:/results";
	}
}
