package edu.upc.essi.dtim.Graph;

import edu.upc.essi.dtim.Graph.Graph;

import java.util.Set;

public class LocalGraph extends Graph {
    public LocalGraph(URI name, Set<Triple> triples) {
        super(name, triples);
    }
}