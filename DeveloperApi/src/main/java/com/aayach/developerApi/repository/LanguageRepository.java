package com.aayach.developerApi.repository;

import com.aayach.developerApi.model.Language;

public interface LanguageRepository {
	
	String saveLanguage(Language language);

	void deleteLanguage(String name);
	
	Language getLanguagebyName(String name);

}
