package edu.upc.essi.dtim.Graph;


public class GlobalGraph extends Graph {

	IntegratedGraph extended;
	private IntegratedGraph integratedGraph;

	/**
	 * getIntegratedGraph
	 * @param integratedGraph IntegratedGraph
	 */
	public GlobalGraph(IntegratedGraph integratedGraph) {
		super(integratedGraph.getName(), integratedGraph.getTriples());
		// TODO - implement GlobalGraph.GlobalGraph
		throw new UnsupportedOperationException();
	}

}