package org.ram.mule.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private String name;

	private String address;

	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
