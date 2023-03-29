package edu.upc.essi.dtim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upc.essi.dtim.DataSources.Dataset;
import edu.upc.essi.dtim.Graph.Graph;
import edu.upc.essi.dtim.Graph.Triple;
import edu.upc.essi.dtim.Queries.Query;
import edu.upc.essi.dtim.Queries.QueryResultSet;
import edu.upc.essi.dtim.Queries.QuerySolution;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.sys.JenaSystem;
import org.apache.jena.system.Txn;

public class GraphStoreJenaImpl implements GraphStoreInterface {

    private Model model;
    private Dataset ds;

//    public GraphStoreJenaImpl(String path){
//        ds = TDBFactory.createDataset(path);
//    }

    static { JenaSystem.init(); }

    @Override
    public void initGraph() {
        model = ModelFactory.createDefaultModel();
        // Configurar la fuente de datos si es necesario
    }

    @Override
    public void addTriple(String subject, String predicate, String object) {
        Resource subj = ResourceFactory.createResource(subject);
        Property pred = ResourceFactory.createProperty(predicate);
        RDFNode obj = ResourceFactory.createPlainLiteral(object);
        Statement stmt = ResourceFactory.createStatement(subj, pred, obj);
        model.add(stmt);
    }

    @Override
    public void removeTriple(String subject, String predicate, String object) {
        Resource subj = ResourceFactory.createResource(subject);
        Property pred = ResourceFactory.createProperty(predicate);
        RDFNode obj = ResourceFactory.createPlainLiteral(object);
        Statement stmt = ResourceFactory.createStatement(subj, pred, obj);
        model.remove(stmt);
    }

    /**
     * Gets a named graph from the store.
     *
     * @param iri The IRI of the named graph.
     * @return The named graph as a Map object, where each key-value pair represents a triple.
     */
    @Override
    public Graph getGraph(String iri) {
        return Txn.calculateRead(ds, ()-> {
            if(ds.containsNamedModel(iri)){
                Model m = ds.getNamedModel(iri);
                return m;
            }
            return null;
        });
    }

    /**
     * Checks whether the store contains a named graph with the given IRI.
     *
     * @param iri The IRI of the named graph to check.
     * @return True if the named graph exists, false otherwise.
     */
    @Override
    public Boolean containsGraph(String iri) {
        return null;
    }

    /**
     * Adds a named graph to the store.
     *
     * @param name  The IRI of the named graph to add.
     * @param graph The graph to add as a Graph object.
     */
    @Override
    public void addGraph(String name, Map<String, String> graph) {

    }

    /**
     * Adds a triple to a named graph.
     *
     * @param namedGraph The IRI of the named graph to add the triple to.
     * @param subject    The subject of the triple.
     * @param predicate  The predicate of the triple.
     * @param object     The object of the triple.
     * @param isLiteral  A flag that indicates whether the object is a literal or not.
     */
    @Override
    public void addTriple(String namedGraph, String subject, String predicate, String object, boolean isLiteral) {

    }

    /**
     * Gets the domain of the given property in the given named graph.
     *
     * @param graphIRI    the IRI of the named graph
     * @param propertyIRI the IRI of the property
     * @return the IRI of the domain of the property
     */
    @Override
    public String getDomainOfProperty(String graphIRI, String propertyIRI) {
        return null;
    }

    /**
     * Gets the RDFS label of a resource in the specified graph.
     *
     * @param graphIRI    the IRI of the graph where the resource is located.
     * @param resourceIRI the IRI of the resource to get the RDFS label from.
     * @return the RDFS label of the resource, or null if it doesn't have one.
     */
    @Override
    public String getRDFSLabel(String graphIRI, String resourceIRI) {
        return null;
    }

    /**
     * Deletes all triples with the specified subject in the specified graph.
     *
     * @param graphIRI   the IRI of the graph where the triples are located.
     * @param subjectIRI the IRI of the subject of the triples to be deleted.
     */
    @Override
    public void deleteTriplesWithSubject(String graphIRI, String subjectIRI) {

    }

    /**
     * Deletes all triples with the specified object in the specified graph.
     *
     * @param graphIRI  the IRI of the graph where the triples are located.
     * @param objectIRI the IRI of the object of the triples to be deleted.
     */
    @Override
    public void deleteTriplesWithObject(String graphIRI, String objectIRI) {

    }

    /**
     * Deletes all triples that match the specified pattern in the specified graph.
     *
     * @param graphIRI the IRI of the graph where the triples are located.
     * @param triple
     */
    @Override
    public void deleteTriples(String graphIRI, Triple triple) {

    }

    /**
     * Deletes the specified graph.
     *
     * @param iri the IRI of the graph to be deleted.
     */
    @Override
    public void deleteGraph(String iri) {

    }

    /**
     * Deletes all graphs.
     */
    @Override
    public void deleteAllGraphs() {

    }

    /**
     * Updates a literal value in the specified graph.
     *
     * @param graphIRI     the IRI of the graph where the literal value is located.
     * @param subjectIRI   the IRI of the subject of the triple where the literal value is located.
     * @param predicateIRI the IRI of the predicate of the triple where the literal value is located.
     * @param oldLiteral   the old value of the literal to be updated.
     * @param newLiteral   the new value of the literal.
     */
    @Override
    public void updateLiteralFromGraph(String graphIRI, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral) {

    }

    /**
     * Updates a literal value in all graphs.
     *
     * @param subjectIRI   the IRI of the subject of the triple where the literal value is located.
     * @param predicateIRI the IRI of the predicate of the triple where the literal value is located.
     * @param oldLiteral   the old value of the literal to be updated.
     * @param newLiteral   the new value of the literal.
     */
    @Override
    public void updateLiteral(String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral) {

    }

    /**
     * This method updates the value of a given literal object in a specific graph, with the given old and new values.
     *
     * @param graphIri     the IRI of the graph where the triple is located.
     * @param subjectIRI   the IRI of the subject of the triple.
     * @param predicateIRI the IRI of the predicate of the triple.
     * @param oldLiteral   the old literal value to be replaced.
     * @param newLiteral   the new literal value to replace the old value.
     */
    @Override
    public void updateLiteral(String graphIri, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral) {

    }

    @Override
    public List<Map<String, String>> query(String sparqlQuery) {
        List<Map<String, String>> resultList = new ArrayList<>();
        Query query = QueryFactory.create(sparqlQuery);
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect();
            List<String> varNames = results.getResultVars();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Map<String, String> row = new HashMap<>();
                for (String varName : varNames) {
                    RDFNode node = soln.get(varName);
                    if (node != null) {
                        row.put(varName, node.toString());
                    }
                }
                resultList.add(row);
            }
        }
        return resultList;
    }

    /**
     * This method runs a SPARQL query on a specific graph and returns the result set.
     *
     * @param query    the SPARQL query to execute.
     * @param graphIRI the IRI of the named graph where the query should be executed.
     * @return a QueryResult object containing the result set of the query.
     */
    @Override
    public QueryResultSet runAQuery(String query, String graphIRI) {
        return null;
    }

    /**
     * This method runs a SPARQL update query on the graph.
     *
     * @param sparqlQuery the SPARQL update query to execute.
     */
    @Override
    public void runAnUpdateQuery(String sparqlQuery) {

    }

    /**
     * This method runs a SPARQL update query on a specific graph of the graph.
     *
     * @param sparqlQuery the SPARQL update query to execute.
     * @param m           the graph where the update query should be executed.
     */
    @Override
    public void runAnUpdateQuery(String sparqlQuery, Graph m) {

    }

    /**
     * This method retrieves a graph containing all resources (IRIs and literals) that are directly or indirectly connected
     * to the resource with the given IRI, in the specified source and URI.
     *
     * @param id  the id of the source where the resource is located.
     * @param uri the URI of the resource to get the integrated graph for.
     * @return the integrated graph of the resource.
     */
    @Override
    public Graph getIntegratedResourcesOfSource(String id, String uri) {
        return null;
    }

    /**
     * This method simplifies a graph by removing all blank nodes that do not have any outgoing properties.
     *
     * @param m the graph to simplify.
     * @return the simplified graph.
     */
    @Override
    public Graph simplify(Graph m) {
        return null;
    }

    /**
     * This method returns a graph containing all properties that are the same as any of the properties in the input graph.
     *
     * @param graph the input graph.
     * @return the graph containing all sameAs properties.
     */
    @Override
    public Graph getPropertiesSameAs(Graph graph) {
        return null;
    }

    /**
     * This method retrieves a subgraph of a given graph, containing only the resources with the given IRIs and their
     * immediate neighbors.
     *
     * @param resources a list of IRIs of the resources to include in the subgraph.
     * @param uri       the URI of the graph to retrieve the subgraph from.
     * @return the subgraph containing the specified resources and their immediate neighbors.
     */
    @Override
    public Graph getSubGraph(List<String> resources, String uri) {
        return null;
    }

    @Override
    public void closeGraph() {
        if (model != null) {
            model.close();
        }
    }
}
