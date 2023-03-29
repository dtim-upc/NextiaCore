package edu.upc.essi.dtim.DataSources;


import java.security.Timestamp;

public class Dataset {

	private String datasetId;
	private String name;
	private String description;
	private DatasetTypes type;
	private Timestamp created_at;

	/**
	 *
	 * @param name
	 */
	public Dataset(String name) {
		// TODO - implement Dataset.Dataset
		throw new UnsupportedOperationException();
	}

	public String getDatasetId() {
		return this.datasetId;
	}

	/**
	 *
	 * @param datasetId
	 */
	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 *
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public DatasetTypes getType() {
		return this.type;
	}

	/**
	 *
	 * @param type
	 */
	public void setType(DatasetTypes type) {
		this.type = type;
	}

	public Timestamp getCreated_at() {
		return this.created_at;
	}

	/**
	 *
	 * @param created_at
	 */
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

}