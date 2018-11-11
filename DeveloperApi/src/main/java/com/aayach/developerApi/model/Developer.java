package com.aayach.developerApi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Developer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4788183309636291089L;

	@Id
	@Column(name = "developer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String firstName;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Developer_Language", joinColumns = { @JoinColumn(name = "developer_id") }, inverseJoinColumns = { @JoinColumn(name = "language_id") })
	private List<Language> languages;

	public Developer() {
		super();

	}

	public Developer(Long id, String name, String firstName,
			List<Language> languages) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.languages = languages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

}
