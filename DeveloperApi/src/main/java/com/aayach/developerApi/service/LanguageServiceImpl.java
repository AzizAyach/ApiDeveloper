package com.aayach.developerApi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.aayach.developerApi.model.Language;
import com.aayach.developerApi.repository.LanguageRepository;

public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	LanguageRepository languageRepository;

	public String saveLanguage(Language language) {
		return languageRepository.saveLanguage(language);
	}

	public void deleteLanguage(String name) {
		languageRepository.deleteLanguage(name);
		
	}

	public Language getLanguagebyName(String name) {
		return getLanguagebyName(name);
	}

}
