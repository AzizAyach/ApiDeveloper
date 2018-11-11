package com.aayach.developerApi.service;

import java.util.List;

import com.aayach.developerApi.model.Developer;

public interface DeveloperService {

	long saveDeveloper(Developer developer);

	Developer getDeveloperbyId(long id);

	List<Developer> getAllDeveloper();

	void updateDeveloper(long id, Developer developer);

	void deleteDeveloper(long id);

	void affectLanguageToDeveloper(String languageName, long idDeveloper);

	List<Developer> getDeveloperbyLanguage(String language);

}
