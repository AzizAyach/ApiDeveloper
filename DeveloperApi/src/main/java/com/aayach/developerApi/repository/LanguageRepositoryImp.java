package com.aayach.developerApi.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.model.Language;


@Repository
public class LanguageRepositoryImp implements LanguageRepository {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	public String saveLanguage(Language language) {
		sessionFactory.getCurrentSession().save(language);
		return language.getName();
	}
	
	public void deleteLanguage(String name) {
		Session session = sessionFactory.getCurrentSession();
		Language language = session.byId(Language.class).load(name);
		session.delete(language);

	}

	public List<Language> getLanguagebyName(String name) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Language> criteriaQuery = cb
				.createQuery(Language.class);
		Root<Language> root = criteriaQuery.from(Language.class);
		criteriaQuery.select(root);
		Query<Language> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public Set<Developer> getDeveloperbyLanguage(String languageName) {
		Language language = sessionFactory.getCurrentSession().get(Language.class, languageName);
		return language.getDevelopers();
	}



}
