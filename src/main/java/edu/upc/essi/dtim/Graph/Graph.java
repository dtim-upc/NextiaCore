package edu.upc.essi.dtim.Graph;

import edu.upc.essi.dtim.Queries.QueryResult;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public abstract class Graph {

	Collection<QueryResult> queryResult;
	private URI name;
	private Set<Triple> triples;

	public Graph(URI name, Set<Triple> triples) {
		this.name = name;
		this.triples = triples;
	}

	public void addTriple(Triple triple) {
		triples.add(triple);
	}

	public void removeTriple(Triple triple) {
		triples.remove(triple);
	}

}