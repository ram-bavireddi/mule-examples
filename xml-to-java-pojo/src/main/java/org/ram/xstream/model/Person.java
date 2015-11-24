package org.ram.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("person")
public class Person {

	@XStreamAlias("name")
	private String name;

	@XStreamAlias("dob")
	private String dob;

	@XStreamAlias("emails")
	private EmailCollection emailCollection;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public EmailCollection getEmailCollection() {
		return emailCollection;
	}

	public void setEmailCollection(EmailCollection emailCollection) {
		this.emailCollection = emailCollection;
	}

}
