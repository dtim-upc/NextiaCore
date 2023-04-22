package edu.upc.essi.dtim.DataSources.dataset;


import edu.upc.essi.dtim.Graph.Graph;
import lombok.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;


@Data
public abstract class Dataset {

	private String datasetId;
	private String name;
	private String path;
	private String description;
	private Timestamp created_at;
	private List<Object> data;

	/**
	 * Constructor for the Dataset class.
	 *
	 * @param id          The ID of the dataset.
	 * @param name        The name of the dataset.
	 * @param description A description of the dataset.
	 * @param path        The path to the dataset file.
	 */
	public Dataset(String id, String name, String description, String path) {
		this.datasetId = id;
		this.name = name;
		this.description = description;
		this.path = path;
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
}