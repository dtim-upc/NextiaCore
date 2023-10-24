package edu.upc.essi.dtim.NextiaCore.discovery;

import lombok.Getter;
import lombok.Setter;
import edu.upc.essi.dtim.NextiaCore.datasources.dataset.Dataset;

import java.util.*;

public class Attribute {
	Collection<Alignment> alignment;
	private String name;
	private String type;

	public Attribute(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Collection<Alignment> getAlignment() {
		return alignment;
	}

	public void setAlignment(Collection<Alignment> alignment) {
		this.alignment = alignment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}