package com.aayach.developerApi.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.model.Language;
import com.aayach.developerApi.repository.LanguageRepository;


@Service
@Transactional(readOnly = true)
public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public String saveLanguage(Language language) {
		return languageRepository.saveLanguage(language);
	}
	@Transactional
	public void deleteLanguage(String name) {
		languageRepository.deleteLanguage(name);
		
	}

	public Language getLanguagebyName(String name) {
		return getLanguagebyName(name);
	}
	public Set<Developer> getDeveloperbyLanguage(String language) {
		return languageRepository.getDeveloperbyLanguage(language);
	}

}
