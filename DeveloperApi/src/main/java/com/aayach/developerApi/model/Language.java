package com.aayach.developerApi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Language implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -800997873480529664L;
	@Id
	@Column(name = "language_id")
	private String name;
	@ManyToMany(mappedBy = "languages")
	List<Developer> developers;

	public Language() {
		super();
	}

	public Language(String name, List<Developer> developers) {
		this.name = name;
		this.developers = developers;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
