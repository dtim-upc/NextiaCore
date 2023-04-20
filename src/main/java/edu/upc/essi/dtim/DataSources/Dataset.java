package edu.upc.essi.dtim.DataSources;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
public class Dataset {

	private String datasetId;
	private String name;
	private String description;
	private Timestamp created_at;

	private List<Object> data;

	/**
	 * Constructor for the Dataset class.
	 * @param name The name of the dataset.
	 */
	public Dataset(String name) {
		this.name = name;
		//throw new UnsupportedOperationException();
	}
}