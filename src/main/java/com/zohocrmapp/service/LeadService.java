package com.zohocrmapp.service;

import java.util.List;

import com.zohocrmapp.entities.Lead;

public interface LeadService {
public void saveOneLead(Lead lead);

public Lead findLeadById(Long id);

public void deleteLadById(Long id);

public List<Lead> getAllLeads();
}
