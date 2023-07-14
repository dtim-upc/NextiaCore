package edu.upc.essi.dtim.NextiaCore.pruebaORMinterface;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.upc.essi.dtim.NextiaCore.graph.Graph;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GraphJenaImpl implements Graph {

    /*
    public GraphJenaImpl(String id, String name, Model triples) {
        this.graph = ModelFactory.createDefaultModel();
        this.graphName = (name != null) ? "http://example/" + name : "null";
    }*/

    public GraphJenaImpl(String graphNameA){
        this.graph = ModelFactory.createDefaultModel();
        this.graphName = graphNameA;
    }
    public GraphJenaImpl() {
        this.graphName = "http://example/";//+ UUID.randomUUID().toString();
        this.graph = ModelFactory.createDefaultModel();
    }

    private String graphName;

    private String graphicalSchema;

    public String getGraphName() {
        return graphName;
    }

    /**
     * @param subject
     * @param predicate
     * @param object
     */
    @Override
    public void addTriple(String subject, String predicate, String object) {

    }

    /**
     * @param subject
     * @param predicate
     * @param object
     */
    @Override
    public void addTripleLiteral(String subject, String predicate, String object) {

    }

    /**
     * @param subject
     * @param predicate
     * @param object
     */
    @Override
    public void deleteTriple(String subject, String predicate, String object) {

    }

    /**
     * @param sparql
     * @return
     */
    @Override
    public List<Map<String, Object>> query(String sparql) {
        return null;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public Model getGraph() {
        return graph;
    }
    public void setGraph(Model graph) {
        this.graph = graph;
    }

    @JsonIgnore
    private Model graph;

    public String getGraphicalSchema() {
        return graphicalSchema;
    }

    public void setGraphicalSchema(String graphicalSchema) {
        this.graphicalSchema = graphicalSchema;
    }

    /**
     * @return
     */
    @Override
    public ResIterator getSubjects() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<String> getPredicates() {
        return null;
    }

    /**
     * @param file
     */
    @Override
    public void write(String file) {

    }

    /**
     * @param propertyIRI
     * @return
     */
    @Override
    public String getDomainOfProperty(String propertyIRI) {
        return null;
    }

    /**
     * @param resourceIRI
     * @return
     */
    @Override
    public String getRDFSLabel(String resourceIRI) {
        return null;
    }
}