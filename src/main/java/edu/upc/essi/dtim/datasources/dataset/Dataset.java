package edu.upc.essi.dtim.datasources.dataset;


import edu.upc.essi.dtim.graph.Graph;

import java.io.IOException;
import java.sql.Timestamp;


public abstract class Dataset {

	private String datasetId;
	private String datasetName;
	private String datasetDescription;
	private Timestamp created_at;
	//private List<Object> data;

	/**
	 * Constructor for the Dataset class.
	 *
	 * @param id          The ID of the dataset.
	 * @param name        The name of the dataset.
	 * @param description A description of the dataset.
	 */
	public Dataset(String id, String name, String description) {
		this.datasetId = id;
		this.datasetName = name;
		this.datasetDescription = description;
	}

	public Dataset() {

	}


	/**
	 * Returns a string representing the type of dataset being used.
	 *
	 * @return a string indicating the dataset type
	 */
	public abstract String getDatasetType();

	/**
	 * Converts a data source into a graph representation.
	 *
	 * @param id the unique identifier for the graph
	 * @param name the name of the graph
	 * @param path the path to the data source to be converted
	 * @return a graph representation of the data source
	 * @throws IOException if there is an error reading the data source
	 */
	public abstract Graph convertToGraph(String id, String name, String path) throws IOException;

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getName() {
		return datasetName;
	}

	public void setName(String name) {
		this.datasetName = name;
	}

	public String getDescription() {
		return datasetDescription;
	}

	public void setDescription(String description) {
		this.datasetDescription = description;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

}