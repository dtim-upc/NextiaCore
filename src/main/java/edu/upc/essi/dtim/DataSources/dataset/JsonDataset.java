package edu.upc.essi.dtim.DataSources.dataset;

import edu.upc.essi.dtim.Graph.Graph;
import edu.upc.essi.dtim.Graph.LocalGraph;
import edu.upc.essi.dtim.Graph.URI;

import java.io.IOException;
import java.util.HashSet;

public class JsonDataset extends Dataset{
    /**
     * Constructor for the JsonDataset class.
     *
     * @param id          The ID of the dataset.
     * @param name        The name of the dataset.
     * @param description A description of the dataset.
     * @param path        The path to the dataset file.
     */
    public JsonDataset(String id, String name, String description, String path) {
        super(id, name, description, path);
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
        return new LocalGraph(new URI(name), new HashSet<>());
    }
}
