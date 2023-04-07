package edu.upc.essi.dtim.Graph;

import edu.upc.essi.dtim.Queries.Mapping;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class URI {
	private String value;

	public URI(String value) {
		this.value = value;
	}

	// Sobreescribimos el método equals para poder comparar URIs
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		URI uri = (URI) o;
		return Objects.equals(value, uri.value);
	}

	// Sobreescribimos el método hashCode para poder comparar URIs
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}