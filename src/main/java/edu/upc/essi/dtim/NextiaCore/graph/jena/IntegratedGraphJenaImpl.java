package edu.upc.essi.dtim.NextiaCore.graph.jena;

import edu.upc.essi.dtim.NextiaCore.graph.IntegratedGraph;
import org.apache.jena.rdf.model.Model;

public class IntegratedGraphJenaImpl extends GraphJenaImpl implements IntegratedGraph {

	GlobalGraphJenaImpl simple;

	public IntegratedGraphJenaImpl(String id, String name, Model triples, String graphicalSchema) {
		super(id, name, triples);
	}

	public IntegratedGraphJenaImpl() {
		super();
	}
}