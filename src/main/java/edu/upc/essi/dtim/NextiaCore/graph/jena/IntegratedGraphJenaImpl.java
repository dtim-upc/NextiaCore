package edu.upc.essi.dtim.NextiaCore.graph.jena;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.upc.essi.dtim.NextiaCore.graph.IntegratedGraph;
import org.apache.jena.rdf.model.Model;

public class IntegratedGraphJenaImpl extends GraphJenaImpl implements IntegratedGraph {

	public GlobalGraphJenaImpl getGlobalGraph() {
		return globalGraph;
	}

	public void setGlobalGraph(GlobalGraphJenaImpl globalGraph) {
		this.globalGraph = globalGraph;
	}

	GlobalGraphJenaImpl globalGraph;

	public IntegratedGraphJenaImpl(String id, String name, Model triples, String graphicalSchema) {
		super();
	}

	public IntegratedGraphJenaImpl() {
		super();
	}
}