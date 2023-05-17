package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

import java.sql.Timestamp;
import java.util.Date;


public class Dataset {

	private String datasetId;
	private String datasetName;
	private String datasetDescription;
	private Date created_at;

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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}