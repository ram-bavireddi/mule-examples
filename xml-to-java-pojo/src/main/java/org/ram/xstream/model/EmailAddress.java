package org.ram.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("email")
public class EmailAddress {

	@XStreamAlias("type")
	private String type;

	@XStreamAlias("address")
	private String address;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
