package edu.upc.essi.dtim.NextiaCore.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class URI {
	private String URI;

	public URI(String value) {
		this.URI = value;
	}

	// Sobreescribimos el método equals para poder comparar URIs
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		URI uri = (URI) o;
		return Objects.equals(URI, uri.URI);
	}

	// Sobreescribimos el método hashCode para poder comparar URIs
	@Override
	public int hashCode() {
		return Objects.hash(URI);
	}
}