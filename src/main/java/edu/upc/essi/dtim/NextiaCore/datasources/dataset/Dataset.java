package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

import edu.upc.essi.dtim.NextiaCore.datasources.Tuple;
import edu.upc.essi.dtim.NextiaCore.graph.Graph;
import edu.upc.essi.dtim.NextiaCore.graph.LocalGraph;

import java.sql.Timestamp;
import java.util.Date;


public class Dataset {

	private String datasetId;
	private String datasetName;
	private String datasetDescription;
	private Date created_at;

	private Graph localGraph;

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
		this.created_at = new Date(System.currentTimeMillis());
	}

	public Dataset() {
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String name) {
		this.datasetName = name;
	}

	public String getDatasetDescription() {
		return datasetDescription;
	}

	public void setDatasetDescription(String description) {
		this.datasetDescription = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Graph getLocalGraph() {
		return localGraph;
	}

	public void setLocalGraph(Graph localGraph) {
		this.localGraph = localGraph;
	}
}