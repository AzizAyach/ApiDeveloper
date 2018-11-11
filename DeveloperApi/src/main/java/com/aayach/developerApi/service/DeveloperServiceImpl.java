package com.aayach.developerApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.repository.DeveloperRepository;


@Service
public class DeveloperServiceImpl implements DeveloperService {

	 @Autowired 
	 DeveloperRepository developerRepository;
	
	
	public long saveDeveloper(Developer developer) {
		return developerRepository.saveDeveloper(developer);
	}

	public Developer getDeveloperbyId(long id) {
		return developerRepository.getDeveloperbyId(id);
	}

	public List<Developer> getAllDeveloper() {
		return developerRepository.getAllDeveloper();
	}

	public void updateDeveloper(long id, Developer developer) {
	  developerRepository.updateDeveloper(id, developer);
		
	}

	public void deleteDeveloper(long id) {
		developerRepository.deleteDeveloper(id);
		
	}

	public void affectLanguageToDeveloper(String languageName, long id) {
		developerRepository.affectLanguageToDeveloper(languageName,id);
		
	}

	public List<Developer> getDeveloperbyLanguage(String language) {
		return developerRepository.getDeveloperbyLanguage(language);
	}

}
