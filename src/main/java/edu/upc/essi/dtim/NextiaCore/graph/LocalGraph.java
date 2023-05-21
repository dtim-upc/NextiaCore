package edu.upc.essi.dtim.NextiaCore.graph;

import java.util.Set;

public class LocalGraph extends Graph {

    public LocalGraph(String id, URI name, Set<Triple> triples) {
        super(id, name, triples);
    }

    public LocalGraph() {
        super();
    }
}