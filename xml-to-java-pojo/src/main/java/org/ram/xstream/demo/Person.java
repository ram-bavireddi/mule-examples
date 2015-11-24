package org.ram.xstream.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TROUBLEMAKER")
public class Person {

	@XStreamAlias("NAME1")
	private String firstName;

	@XStreamAlias("NAME2")
	private String lastName;

	@XStreamAlias("AGE")
	private int age;

	@XStreamAlias("NUMBER")
	private String documentNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

}
