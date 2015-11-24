package org.ram.xstream.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BAN")
public class Ban {

	@XStreamAlias("UPDATED_AT")
	private String dateOfUpdate;

	@XStreamAlias("TROUBLEMAKER")
	private Person person;

	public String getDateOfUpdate() {
		return dateOfUpdate;
	}

	public void setDateOfUpdate(String dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
