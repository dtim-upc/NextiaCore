package edu.upc.essi.dtim.NextiaCore.graph;

import java.util.Set;

public class IntegratedGraph extends Graph {

	GlobalGraph simple;

	public IntegratedGraph(String id, URI name, Set<Triple> triples, String graphicalSchema) {
		super(id, name, triples);
	}
}