package edu.upc.essi.dtim.Discovery;

import java.util.*;

public class Attribute {

	Collection<Alignment> alignment;
	private String name;
	private String type;

	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	/**
	 *
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}