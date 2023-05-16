package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

import edu.upc.essi.dtim.NextiaCore.graph.Triple;
import edu.upc.essi.dtim.NextiaCore.graph.Graph;
import edu.upc.essi.dtim.NextiaCore.graph.LocalGraph;
import edu.upc.essi.dtim.NextiaCore.graph.URI;
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
}
