package edu.upc.essi.dtim.NextiaCore.graph.jena;

import edu.upc.essi.dtim.NextiaCore.graph.IntegratedGraph;
import edu.upc.essi.dtim.NextiaCore.graph.LocalGraph;
import edu.upc.essi.dtim.NextiaCore.graph.Triple;
import edu.upc.essi.dtim.NextiaCore.graph.URI;

import java.util.Set;

public class IntegratedGraphJena extends GraphJena implements IntegratedGraph {

	GlobalGraphJena simple;

	public IntegratedGraphJena(String id, URI name, Set<Triple> triples, String graphicalSchema) {
		super(id, name, triples);
	}
}