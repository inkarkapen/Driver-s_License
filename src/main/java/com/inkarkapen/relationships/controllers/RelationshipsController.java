package com.inkarkapen.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inkarkapen.relationships.models.License;
import com.inkarkapen.relationships.models.Person;
import com.inkarkapen.relationships.services.LicenseService;
import com.inkarkapen.relationships.services.PersonService;



@Controller
public class RelationshipsController {
	private final PersonService personService;
	public RelationshipsController(PersonService personService) {
		this.personService = personService;
	}
	@RequestMapping("/person/new")
	public String addPerson(Model model) {
		model.addAttribute("person", new Person());
		return "person.jsp";
	}
	@PostMapping("/person/create")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "person.jsp";
		}
		else {
			PersonService.newPerson(person);
			return "redirect:/license/new";
		}
	}
	@RequestMapping("license/new")
	public String addLicense(Model model) {
		List<Person> persons = PersonService.allPersons();
		model.addAttribute("persons", persons);
		model.addAttribute("license", new License());
		return "license.jsp";
	}
	@PostMapping("license/create")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp";
		} 
		else {
			Person person = license.getPerson();
			String licenseNum = String.format("%06d", person.getId());
			license.setNumber(licenseNum);
			LicenseService.newLicense(license);
			return "redirect:/persons/" + person.getId();
		}
	}
	@RequestMapping("/persons/{id}")
	public String showPerson(Model model, @PathVariable("id") Long id) {
		Person person = PersonService.findById(id);
		model.addAttribute("person", person);
		return "show.jsp";
	}
}
