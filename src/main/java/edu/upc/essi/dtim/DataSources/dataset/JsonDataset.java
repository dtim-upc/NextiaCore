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
        if (!path.endsWith(".json")) {
            throw new IllegalArgumentException("Invalid file format. Only JSON files are supported.");
        }
    }

    /**
     * Returns the type of the dataset.
     *
     * @return The type of the dataset as a String. In this case, it always returns "json".
     */
    @Override
    public String getDatasetType() {
        return "json";
    }

    /**
     * Converts the data source located at the specified path into a graph.
     *
     * @param id   The unique identifier for the graph.
     * @param name The name of the graph.
     * @param path The path to the data source to be converted.
     * @return A Graph object representing the converted data source.
     * @throws IOException If there is an error reading or parsing the data source.
     */
    @Override
    public Graph convertToGraph(String id, String name, String path) throws IOException {
        return new LocalGraph(new URI(id), new HashSet<>());
    }
}