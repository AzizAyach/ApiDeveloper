package com.aayach.developerApi.service;

import com.aayach.developerApi.model.Language;

public interface LanguageService {
	
	String saveLanguage(Language language);

	void deleteLanguage(String name);
	
	Language getLanguagebyName(String name);

}
