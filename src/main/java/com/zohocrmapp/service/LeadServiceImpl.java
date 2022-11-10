package com.zohocrmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.repositories.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
@Autowired
private LeadRepository leadRepo;
	@Override
	public void saveOneLead(Lead lead) {
leadRepo.save(lead);		
	}
	@Override
	public Lead findLeadById(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	@Override
	public void deleteLadById(Long id) {

		leadRepo.deleteById(id);
	}
	@Override
	public List<Lead> getAllLeads() {
List<Lead> leads = leadRepo.findAll();

		return leads;
	}

}
