package edu.upc.essi.dtim.Graph;

import java.util.Set;

public class IntegratedGraph extends Graph {

	GlobalGraph simple;

	public IntegratedGraph(URI name, Set<Triple> triples) {
		super(name, triples);
	}
}