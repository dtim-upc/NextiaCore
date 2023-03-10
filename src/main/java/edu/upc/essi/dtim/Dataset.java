package edu.upc.essi.dtim;

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

	public String getDatasetName() {
		// TODO - implement Dataset.getDatasetName
		throw new UnsupportedOperationException();
	}

	/**
	 * allows the user to edit the name of the dataset
	 * @param name
	 */
	public void setDatasetName(String name) {
		// TODO - implement Dataset.setDatasetName
		throw new UnsupportedOperationException();
	}

	public String getDatasetDescription() {
		// TODO - implement Dataset.getDatasetDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * allows the user to edit the desscription of the dataset
	 * @param description
	 */
	public void setDatasetDescription(String description) {
		// TODO - implement Dataset.setDatasetDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * retrieves the type of a specific dataset
	 */
	public DatasetTypes getDatasetType() {
		// TODO - implement Dataset.getDatasetType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public void setDatasetType(DatasetTypes type) {
		// TODO - implement Dataset.setDatasetType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param datasetId
	 */
	public void getDatasetDateCreation(String datasetId) {
		// TODO - implement Dataset.getDatasetDateCreation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param creationDate
	 */
	public void setDatasetDateCreation(Timestamp creationDate) {
		// TODO - implement Dataset.setDatasetDateCreation
		throw new UnsupportedOperationException();
	}

}