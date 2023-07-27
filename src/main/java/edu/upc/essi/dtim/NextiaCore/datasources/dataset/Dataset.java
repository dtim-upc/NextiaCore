package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

import edu.upc.essi.dtim.NextiaCore.datasources.DataResource;
import edu.upc.essi.dtim.NextiaCore.datasources.dataRepository.DataRepository;
import edu.upc.essi.dtim.NextiaCore.graph.LocalGraph;
import edu.upc.essi.dtim.NextiaCore.graph.jena.GraphJenaImpl;
import edu.upc.essi.dtim.NextiaCore.graph.jena.LocalGraphJenaImpl;
//import edu.upc.essi.dtim.NextiaCore.pruebaORMinterface.GraphJenaImpl;

import java.sql.Timestamp;
import java.util.Date;


public class Dataset extends DataResource {
	private String datasetName;
	private String datasetDescription;
	private Date created_at;

	public DataRepository getRepository() {
		return repository;
	}

	public void setRepository(DataRepository repository) {
		this.repository = repository;
	}

	// Nuevo atributo para la referencia al DataRepository
	private DataRepository repository;


	public LocalGraphJenaImpl getLocalGraph() {
		return localGraph;
	}

	public void setLocalGraph(LocalGraphJenaImpl localGraph) {
		this.localGraph = localGraph;
	}

	private LocalGraphJenaImpl localGraph;



	/**
	 * Constructor for the Dataset class.
	 *
	 * @param id          The ID of the dataset.
	 * @param name        The name of the dataset.
	 * @param description A description of the dataset.
	 */
	public Dataset(String id, String name, String description) {
		this.datasetName = name;
		this.datasetDescription = description;
		this.created_at = new Date(System.currentTimeMillis());
	}

	public Dataset() {
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
}