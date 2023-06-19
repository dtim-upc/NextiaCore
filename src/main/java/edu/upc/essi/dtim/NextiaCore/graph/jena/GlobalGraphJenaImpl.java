package edu.upc.essi.dtim.NextiaCore.graph.jena;


import edu.upc.essi.dtim.NextiaCore.graph.GlobalGraph;

public class GlobalGraphJenaImpl extends GraphJenaImpl implements GlobalGraph {

	IntegratedGraphJenaImpl extended;
	private IntegratedGraphJenaImpl integratedGraph;

	/**
	 * getIntegratedGraph
	 * @param integratedGraph IntegratedGraph
	 */
	public GlobalGraphJenaImpl(IntegratedGraphJenaImpl integratedGraph) {
		super(null, integratedGraph.getGraphName(), integratedGraph.getGraph());
		// TODO - implement GlobalGraph.GlobalGraph
		throw new UnsupportedOperationException();
	}

	public GlobalGraphJenaImpl(){
		super();
	}

}