package edu.upc.essi.dtim.CoreGraph;

import edu.upc.essi.dtim.Queries.QueryResult;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Graph {

	/**
	 * Collection to store query results
	 */
	Collection<QueryResult> queryResult;

	/**
	 * URI to represent the name of the graph
	 */
	private URI name;

	/**
	 * Set to store triples in the graph
	 */
	private Set<Triple> triples;

	URI getName(){
		return this.name;
	}

	Set<Triple> getTriples(){
		return this.triples;
	}

	/**
	 * Constructor to initialize the graph with a name and set of triples
	 *
	 * @param name     the name of the graph
	 * @param triples  the set of triples to be stored in the graph
	 */
	public Graph(URI name, Set<Triple> triples) {
		this.name = name;
		this.triples = triples;
	}

	/**
	 * Method to add a triple to the graph
	 *
	 * @param triple  the triple to be added to the graph
	 */
	public void addTriple(Triple triple) {
		triples.add(triple);
	}

	/**
	 * Method to remove a triple from the graph
	 *
	 * @param triple  the triple to be removed from the graph
	 */
	public void removeTriple(Triple triple) {
		triples.remove(triple);
	}

	/**
	 * Method to get the size of the graph (number of triples)
	 *
	 * @return the size of the graph
	 */
	public int size() {
		return triples.size();
	}

	// Method to create a default graph
	public static Graph createDefaultGraph() {
		// Create a set of triples for the graph
		Set<Triple> triples = new HashSet<>();

		// Create a new Graph object
		Graph graph = new LocalGraph(new URI("defaultGraph"), triples);

		return graph;
	}
}