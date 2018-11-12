package com.aayach.developerApi.repository;

import java.util.List;
import java.util.Set;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.model.Language;

public interface LanguageRepository {
	
	String saveLanguage(Language language);

	void deleteLanguage(String name);
	
	List<Language> getLanguagebyName(String name);
	
	Set<Developer> getDeveloperbyLanguage(String language);

}
