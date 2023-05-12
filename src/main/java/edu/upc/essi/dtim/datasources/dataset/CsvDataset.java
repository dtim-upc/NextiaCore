package edu.upc.essi.dtim.datasources.dataset;

import edu.upc.essi.dtim.graph.Graph;
import edu.upc.essi.dtim.graph.LocalGraph;
import edu.upc.essi.dtim.graph.Triple;
import edu.upc.essi.dtim.graph.URI;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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

    /**
     * Returns the type of the dataset.
     *
     * @return The type of the dataset as a String. In this case, it always returns "csv".
     */
    @Override
    public String getDatasetType() {
        return "csv";
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
    public Graph convertToGraph(String id, String name, String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        // Use a CSV parser for the CSV file
        CSVParser reader = CSVParser.parse(br, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        // Create a new triple for each row of data in the CSV file
        Set<Triple> triples = new HashSet<>();
        for (CSVRecord record : reader) {
            String subjectString = record.get("Name");
            String predicateString = record.get("Age");
            String objectString = record.get("City");

            URI subject = new URI(subjectString);
            URI predicate = new URI(predicateString);
            URI object = new URI(objectString);
            Triple triple = new Triple(subject, predicate, object);

            triples.add(triple);
        }

        Graph graph = new LocalGraph(new URI(id), triples);

        return graph;
    }
}
