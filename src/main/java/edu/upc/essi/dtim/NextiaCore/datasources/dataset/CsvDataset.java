package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

public class CsvDataset extends Dataset{

    public CsvDataset(){
        super();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

    public String getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = datasetType;
    }

    private String datasetType = "csv";

    /**
     * Constructor for the CsvDataset class.
     *
     * @param id          The ID of the dataset.
     * @param name        The name of the dataset.
     * @param description A description of the dataset.
     * @param path        The path to the dataset file.
     */
    public CsvDataset(String id, String name, String description, String path) {
        super(id, name, description);
        if (!path.endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file format. Only CSV files are supported.");
        }
        this.path = path;
    }
}