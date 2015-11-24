package org.ram.xstream.demo;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("DATA")
public class Data {

	@XStreamImplicit(itemFieldName = "BAN")
	private List<Ban> dataBans = new ArrayList<>();

	public List<Ban> getDataBans() {
		return dataBans;
	}

	public void setDataBans(List<Ban> dataBans) {
		this.dataBans = dataBans;
	}

}
