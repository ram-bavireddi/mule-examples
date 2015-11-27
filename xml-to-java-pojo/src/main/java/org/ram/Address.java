package org.ram;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
