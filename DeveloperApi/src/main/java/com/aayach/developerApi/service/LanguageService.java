package com.aayach.developerApi.service;

import java.util.Set;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.model.Language;

public interface LanguageService {
	
	String saveLanguage(Language language);

	void deleteLanguage(String name);
	
	Language getLanguagebyName(String name);
	
	Set<Developer> getDeveloperbyLanguage(String language);

}
