package edu.upc.essi.dtim.NextiaCore.graph;


public class GlobalGraph extends Graph {

	IntegratedGraph extended;
	private IntegratedGraph integratedGraph;

	/**
	 * getIntegratedGraph
	 * @param integratedGraph IntegratedGraph
	 */
	public GlobalGraph(IntegratedGraph integratedGraph) {
		super(null, integratedGraph.getName(), integratedGraph.getTriples());
		// TODO - implement GlobalGraph.GlobalGraph
		throw new UnsupportedOperationException();
	}

}