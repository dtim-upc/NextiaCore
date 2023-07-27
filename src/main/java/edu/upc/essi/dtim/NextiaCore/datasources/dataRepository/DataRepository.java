package edu.upc.essi.dtim.NextiaCore.datasources.dataRepository;

import edu.upc.essi.dtim.NextiaCore.datasources.DataResource;
import edu.upc.essi.dtim.NextiaCore.datasources.dataset.Dataset;

import java.util.ArrayList;
import java.util.List;

public class DataRepository extends DataResource {
    private List<Dataset> datasets;

    public DataRepository() {
        datasets = new ArrayList<>();
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void addDataset(Dataset dataset) {
        datasets.add(dataset);
        dataset.setRepository(this); // Establecer la referencia al DataRepository en el Dataset
    }

    public void removeDataset(Dataset dataset) {
        datasets.remove(dataset);
        dataset.setRepository(null); // Eliminar la referencia al DataRepository en el Dataset
    }
}