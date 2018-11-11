package com.aayach.developerApi.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.model.Language;


@Repository
public class DeveloperRepositoryImpl implements DeveloperRepository {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	public long saveDeveloper(Developer developer) {
		sessionFactory.getCurrentSession().save(developer);
		return developer.getId();
	}

	public List<Developer> getAllDeveloper() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Developer> criteriaQuery = cb
				.createQuery(Developer.class);
		Root<Developer> root = criteriaQuery.from(Developer.class);
		criteriaQuery.select(root);
		Query<Developer> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	@Transactional
	public void updateDeveloper(long id, Developer developer) {
		  Session session = sessionFactory.getCurrentSession();
	      Developer developerUp = session.byId(Developer.class).load(id);
	      developerUp.setFirstName(developer.getFirstName());
	      developerUp.setName(developer.getName());
	      session.flush();

	}
	
	@Transactional
	public void deleteDeveloper(long id) {
		Session session = sessionFactory.getCurrentSession();
		Developer developer = session.byId(Developer.class).load(id);
		session.delete(developer);

	}
	@Transactional
	public void affectLanguageToDeveloper(String languageName, long id) {
		Language language = sessionFactory.getCurrentSession().get(Language.class, languageName);
		Developer developer = sessionFactory.getCurrentSession().get(Developer.class, id);
		developer.getLanguages().add(language);

	}

	public List<Developer> getDeveloperbyLanguage(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	public Developer getDeveloperbyId(long id) {
		return sessionFactory.getCurrentSession().get(Developer.class, id);
	}

}
