package edu.upc.essi.dtim.DataSources.dataset;

import edu.upc.essi.dtim.Graph.Graph;
import edu.upc.essi.dtim.Graph.LocalGraph;
import edu.upc.essi.dtim.Graph.Triple;
import edu.upc.essi.dtim.Graph.URI;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CsvDataset extends Dataset{
    private final String delimiter;
    /**
     * Constructor for the CsvDataset class.
     * @param name The name of the dataset.
     */
    public CsvDataset(String id, String name, String path, String delimiter) {
        super(id, name, path);
        this.delimiter = delimiter;
    }



    /**
     * Abstract method to extract data from the dataset.
     *
     * @return csv
     */
    @Override
    public String getDatasetType() {
        return "csv";
    }

    /**
     * Converts a CSV file at the given path to a graph.
     *
     * @param id   the ID of the graph
     * @param name the name of the graph
     * @param path the path to the CSV file
     * @return a graph containing the data from the CSV file
     * @throws IOException if an I/O error occurs while reading the CSV file
     */
    public Graph convertToGraph(String id, String name, String path) throws IOException {
        Graph graph = new LocalGraph(new URI(id), new HashSet<>());
        BufferedReader br = new BufferedReader(new FileReader(path));

        // Use a CSV parser for the CSV file
        CSVParser reader = CSVParser.parse(br, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        // Create a new triple for each row of data in the CSV file
        for (CSVRecord record : reader) {
            String subjectString = record.get("subject");
            String predicateString = record.get("predicate");
            String objectString = record.get("object");

            URI subject = new URI(subjectString);
            URI predicate = new URI(predicateString);
            URI object = new URI(objectString);
            Triple triple = new Triple(subject, predicate, object);

            graph.addTriple(triple);
        }

        return graph;
    }
}
