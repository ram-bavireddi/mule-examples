package org.mule.forum.answer.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("persons")
public class Persons {

	@XStreamImplicit(itemFieldName = "person")
	private List<Person> entries = new ArrayList<>();

	public List<Person> getEntries() {
		return entries;
	}

	public void setEntries(List<Person> entries) {
		this.entries = entries;
	}
}
