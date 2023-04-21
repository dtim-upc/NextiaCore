package edu.upc.essi.dtim.DataSources.dataset;

import edu.upc.essi.dtim.Graph.Graph;

import java.io.IOException;

public class JsonDataset extends Dataset{
    /**
     * Constructor for the JsonDataset class.
     * @param name The name of the dataset.
     */
    public JsonDataset(String id, String name, String path) {
        super(id, name, path);
    }

    @Override
    public String getDatasetType() {
        return "json";
    }

    /**
     * @param id   the unique identifier for the graph
     * @param name the name of the graph
     * @param path the path to the data source to be converted
     * @return
     * @throws IOException
     */
    @Override
    public Graph convertToGraph(String id, String name, String path) throws IOException {
        return null;
    }
}
