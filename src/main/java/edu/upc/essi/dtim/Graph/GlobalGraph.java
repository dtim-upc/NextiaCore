package edu.upc.essi.dtim.Graph;

public class GlobalGraph extends Graph {

	IntegratedGraph extended;
	private IntegratedGraph integratedGraph;

	/**
	 * 
	 * @param integratedGraph
	 */
	public GlobalGraph(IntegratedGraph integratedGraph) {
		super(integratedGraph.getName(), integratedGraph.getTriples());
		// TODO - implement GlobalGraph.GlobalGraph
		throw new UnsupportedOperationException();
	}

	public IntegratedGraph getIntegratedGraph() {
		return this.integratedGraph;
	}

	/**
	 * 
	 * @param integratedGraph
	 */
	public void setIntegratedGraph(IntegratedGraph integratedGraph) {
		// TODO - implement GlobalGraph.setIntegratedGraph
		throw new UnsupportedOperationException();
	}

}