package edu.upc.essi.dtim.NextiaCore.graph;

import java.util.Set;

public class LocalGraph extends Graph {
    public LocalGraph(String id, URI name, Set<Triple> triples, String graphicalSchema) {
        super(id, name, triples, graphicalSchema);
    }

    public LocalGraph() {
        super();
    }
}