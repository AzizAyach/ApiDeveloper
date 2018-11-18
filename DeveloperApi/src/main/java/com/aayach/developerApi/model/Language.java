package com.aayach.developerApi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Language implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -800997873480529664L;
	@Id
	@Column(name = "language_id")
	private String name;
	@ManyToMany(mappedBy = "languages",fetch=FetchType.EAGER)
	@JsonIgnore
	Set<Developer> developers;

	public Language() {
		super();
	}

	public Language(String name, Set<Developer> developers) {
		this.name = name;
		this.developers = developers;
	}

	public Set<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
