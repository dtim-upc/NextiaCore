package edu.upc.essi.dtim.NextiaCore.graph;

import edu.upc.essi.dtim.NextiaCore.queries.QueryResult;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Graph {
	/**
	 * Id just for relational DB
	 */
	private String id;

	/**
	 * URI to represent the name of the graph
	 */
	private URI name;


	/**
	 * Set to store triples in the graph.
	 */
	private Set<Triple> triples;

	private String graphicalSchema;

	public String getGraphicalSchema() {
		return graphicalSchema;
	}

	public void setGraphicalSchema(String graphicalSchema) {
		this.graphicalSchema = graphicalSchema;
	}

	/**
	 * Constructor to initialize the graph with a name and set of triples
	 *
	 * @param name     the name of the graph
	 * @param triples  the set of triples to be stored in the graph
	 */
	public Graph(String id, URI name, Set<Triple> triples) {
		this.id = id;
		this.name = name;
		this.triples = triples;
	}

	public Graph() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}