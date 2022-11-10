package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.service.ContactService;
import com.zohocrmapp.service.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private ContactService contactService;
@GetMapping("/viewCreateLeadPage")
public String viewCreateLeadPage() {
	return "create_new_lead";
}
@PostMapping("/saveLead")
public String saveLead(@ModelAttribute("lead") Lead lead,Model model) {
	leadService.saveOneLead(lead);
	model.addAttribute("lead", lead);
	return "lead_info";
}
@PostMapping("/convertLead")
public String convertLead(@RequestParam("id") Long id,Model model) {
	Lead lead=leadService.findLeadById(id);
	Contact contact =new Contact();
	contact.setFirstName(lead.getFirstName());
	contact.setLastName(lead.getLastName());
	contact.setEmail(lead.getEmail());
	contact.setMobile(lead.getMobile());
	contact.setSource(lead.getSource());
	contactService.saveContact(contact);
	leadService.deleteLadById(id);
	
	List<Contact> contacts = contactService.getAllContacts();
	model.addAttribute("contacts", contacts);
return"list_contacts";	
}
@RequestMapping("/listall")
public String listAllLeads(Model model) {
	List<Lead> leads = leadService.getAllLeads();
	model.addAttribute("leads", leads);
	return "list_leads";
	
}
@RequestMapping("/leadinfo")
public String leadInfo(@RequestParam("id") Long id ,Model model) {
	Lead lead = leadService.findLeadById(id);
	model.addAttribute("lead", lead);
	return"lead_info";
	
}
}
