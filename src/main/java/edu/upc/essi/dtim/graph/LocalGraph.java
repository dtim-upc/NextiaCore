package edu.upc.essi.dtim.graph;

import java.util.Set;

public class LocalGraph extends Graph {
    public LocalGraph(URI name, Set<Triple> triples) {
        super(name, triples);
    }
}