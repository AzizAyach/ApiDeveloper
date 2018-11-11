package com.aayach.developerApi.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aayach.developerApi.model.Language;


@Repository
public class LanguageRepositoryImp implements LanguageRepository {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	public String saveLanguage(Language language) {
		sessionFactory.getCurrentSession().save(language);
		return language.getName();
	}
	@Transactional
	public void deleteLanguage(String name) {
		Session session = sessionFactory.getCurrentSession();
		Language language = session.byId(Language.class).load(name);
		session.delete(language);

	}

	public Language getLanguagebyName(String name) {
		return sessionFactory.getCurrentSession().get(Language.class, name);
	}



}
