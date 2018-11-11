package com.aayach.developerApi.repository;

import java.util.List;

import com.aayach.developerApi.model.Developer;

public interface DeveloperRepository {

	long saveDeveloper(Developer developer);

	Developer getDeveloperbyId(long id);

	List<Developer> getAllDeveloper();

	void updateDeveloper(long id, Developer developer);

	void deleteDeveloper(long id);

	void affectLanguageToDeveloper(String languageName,  long id);
	
	List<Developer> getDeveloperbyLanguage(String language);

}
