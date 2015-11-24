package org.ram.xstream.demo;

import com.thoughtworks.xstream.XStream;

public class DataParser {

	public static void main(String[] args) {
		XStream xStream = new XStream();
		xStream.processAnnotations(new Class[] { Data.class, Ban.class, Person.class });
		Data data = (Data) xStream.fromXML(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("org/ram/xstream/demo/data.xml"));

		System.out.println("Number of bans = " + data.getDataBans().size());
	}
}
