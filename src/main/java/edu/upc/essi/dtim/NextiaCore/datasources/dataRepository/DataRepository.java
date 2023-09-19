package edu.upc.essi.dtim.NextiaCore.datasources.dataRepository;

import edu.upc.essi.dtim.NextiaCore.datasources.DataResource;
import edu.upc.essi.dtim.NextiaCore.datasources.dataset.Dataset;

import java.util.ArrayList;
import java.util.List;

public class DataRepository extends DataResource {
    public DataRepository() {

        //datasets = new ArrayList<>();
    }

    private List<Dataset> datasets;

    private String repositoryName;

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

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