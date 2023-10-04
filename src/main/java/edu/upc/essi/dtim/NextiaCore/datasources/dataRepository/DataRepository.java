package edu.upc.essi.dtim.NextiaCore.datasources.dataRepository;

import edu.upc.essi.dtim.NextiaCore.datasources.dataset.Dataset;
import java.util.List;

public class DataRepository {
    private String id;
    private String repositoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryType() {
        return this.getClass().getSimpleName(); // Retorna el nombre de la clase concreta
    }

    private List<Dataset> datasets;

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void addDataset(Dataset dataset) {
        datasets.add(dataset);
    }

    public void removeDataset(Dataset dataset) {
        datasets.remove(dataset);
    }
}