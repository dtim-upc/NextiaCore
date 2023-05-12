package edu.upc.essi.dtim.NextiaCore.graph;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Triple {
	private final URI subject;
	private final URI predicate;
	private final Object object;

	public Triple(URI subject, URI predicate, URI object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}

	@Override
	public String toString() {
		if (object instanceof URI) {
			return subject.toString() + " " + predicate.toString() + " " + ((URI) object).toString() + " .";
		} else {
			return subject.toString() + " " + predicate.toString() + " \"" + object.toString() + "\" .";
		}
	}

	public boolean hasLiteralObject() {
		// Check if object is a literal type (String, Integer, or Double)
		return object instanceof String || object instanceof Integer || object instanceof Double;
	}

	public String getLiteralObjectValue() {
		if (hasLiteralObject()) {
			// If object is a literal, return its value as a string
			return object.toString();
		} else {
			// If object is not a literal, throw an exception
			throw new IllegalStateException("The object is not a literal.");
		}
	}

	public String getLiteralObjectDatatypeURI() {
		// We assume every literal is string type, so return its URI
		if (hasLiteralObject()) {
			return "http://www.w3.org/2001/XMLSchema#string";
		} else {
			// If object is not a literal, throw an exception
			throw new IllegalStateException("The object is not a literal.");
		}
	}

}