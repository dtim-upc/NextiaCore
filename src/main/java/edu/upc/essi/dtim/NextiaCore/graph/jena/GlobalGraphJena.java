package edu.upc.essi.dtim.NextiaCore.graph.jena;


import edu.upc.essi.dtim.NextiaCore.graph.GlobalGraph;

public class GlobalGraphJena extends GraphJena implements GlobalGraph {

	IntegratedGraphJena extended;
	private IntegratedGraphJena integratedGraph;

	/**
	 * getIntegratedGraph
	 * @param integratedGraph IntegratedGraph
	 */
	public GlobalGraphJena(IntegratedGraphJena integratedGraph) {
		super(null, integratedGraph.getGraphName(), integratedGraph.getGraph());
		// TODO - implement GlobalGraph.GlobalGraph
		throw new UnsupportedOperationException();
	}

}