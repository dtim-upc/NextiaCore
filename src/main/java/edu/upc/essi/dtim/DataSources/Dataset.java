package edu.upc.essi.dtim.DataSources;


import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
public class Dataset {

	private String datasetId;
	private String name;
	private String description;
	private Timestamp created_at;

	/**
	 *
	 * @param name
	 */
	public Dataset(String name) {
		// TODO - implement Dataset.Dataset
		throw new UnsupportedOperationException();
	}
}