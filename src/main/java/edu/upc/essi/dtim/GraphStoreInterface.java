package edu.upc.essi.dtim;

import java.util.List;
import java.util.Map;

/**
 * Interface for a Graph Store that abstracts the underlying implementation of RDF graphs and enables the decoupling of the
 * application code from the RDF API used to manipulate the data. The methods defined in this interface provide a simplified
 * API that hides the complexity of the underlying RDF implementation, making it easier to change the database in the future
 * without changing the application code.
 */
public interface GraphStoreInterface {

    /**
     * Initializes the RDF graph and establishes the necessary connections to the data source.
     */
    void initGraph();

    /**
     * Adds a triple to the graph.
     *
     * @param subject   The subject of the triple.
     * @param predicate The predicate of the triple.
     * @param object    The object of the triple.
     */
    void addTriple(String subject, String predicate, String object);

    /**
     * Removes a triple from the graph.
     *
     * @param subject   The subject of the triple.
     * @param predicate The predicate of the triple.
     * @param object    The object of the triple.
     */
    void removeTriple(String subject, String predicate, String object);

    /**
     * Gets a named graph from the store.
     *
     * @param iri The IRI of the named graph.
     * @return The named graph as a Map object, where each key-value pair represents a triple.
     */
    Map<String, String> getGraph(String iri);

    /**
     * Checks whether the store contains a named graph with the given IRI.
     *
     * @param iri The IRI of the named graph to check.
     * @return True if the named graph exists, false otherwise.
     */
    Boolean containsGraph(String iri);

    /**
     * Adds a named graph to the store.
     *
     * @param name  The IRI of the named graph to add.
     * @param graph The graph to add as a Graph object.
     */
    void addGraph(String name, Map<String, String> graph);


    /**
     * Adds a triple to a named graph.
     *
     * @param namedGraph The IRI of the named graph to add the triple to.
     * @param subject    The subject of the triple.
     * @param predicate  The predicate of the triple.
     * @param object     The object of the triple.
     * @param isLiteral  A flag that indicates whether the object is a literal or not.
     */
    void addTriple(String namedGraph, String subject, String predicate, String object, boolean isLiteral);


    /**
     * Gets the domain of the given property in the given named graph.
     *
     * @param graphIRI    the IRI of the named graph
     * @param propertyIRI the IRI of the property
     * @return the IRI of the domain of the property
     */
    String getDomainOfProperty(String graphIRI, String propertyIRI);

    /**
     * Gets the RDFS label of a resource in the specified graph.
     *
     * @param graphIRI    the IRI of the graph where the resource is located.
     * @param resourceIRI the IRI of the resource to get the RDFS label from.
     * @return the RDFS label of the resource, or null if it doesn't have one.
     */
    String getRDFSLabel(String graphIRI, String resourceIRI);

    /**
     * Deletes all triples with the specified subject in the specified graph.
     *
     * @param graphIRI   the IRI of the graph where the triples are located.
     * @param subjectIRI the IRI of the subject of the triples to be deleted.
     */
    void deleteTriplesWithSubject(String graphIRI, String subjectIRI);

    /**
     * Deletes all triples with the specified object in the specified graph.
     *
     * @param graphIRI  the IRI of the graph where the triples are located.
     * @param objectIRI the IRI of the object of the triples to be deleted.
     */
    void deleteTriplesWithObject(String graphIRI, String objectIRI);

    /**
     * Deletes all triples that match the specified pattern in the specified graph.
     *
     * @param graphIRI     the IRI of the graph where the triples are located.
     * @param subjectIRI   the IRI of the subject of the triples to be deleted.
     * @param predicateIRI the IRI of the predicate of the triples to be deleted.
     * @param objectIRI    the IRI of the object of the triples to be deleted.
     */
    void deleteTriples(String graphIRI, String subjectIRI, String predicateIRI, String objectIRI);

    /**
     * Deletes the specified graph.
     *
     * @param iri the IRI of the graph to be deleted.
     */
    void deleteGraph(String iri);

    /**
     * Deletes all graphs.
     */
    void deleteAllGraphs();

    /**
     * Updates a literal value in the specified graph.
     *
     * @param graphIRI     the IRI of the graph where the literal value is located.
     * @param subjectIRI   the IRI of the subject of the triple where the literal value is located.
     * @param predicateIRI the IRI of the predicate of the triple where the literal value is located.
     * @param oldLiteral   the old value of the literal to be updated.
     * @param newLiteral   the new value of the literal.
     */
    void updateLiteralFromGraph(String graphIRI, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral);

    /**
     * Updates a literal value in all graphs.
     *
     * @param subjectIRI   the IRI of the subject of the triple where the literal value is located.
     * @param predicateIRI the IRI of the predicate of the triple where the literal value is located.
     * @param oldLiteral   the old value of the literal to be updated.
     * @param newLiteral   the new value of the literal.
     */
    void updateLiteral(String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral);

    /**
     * This method updates the value of a given literal object in a specific graph, with the given old and new values.
     *
     * @param graphIri     the IRI of the graph where the triple is located.
     * @param subjectIRI   the IRI of the subject of the triple.
     * @param predicateIRI the IRI of the predicate of the triple.
     * @param oldLiteral   the old literal value to be replaced.
     * @param newLiteral   the new literal value to replace the old value.
     */
    void updateLiteral(String graphIri, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral);

    /**
     * This method runs a SPARQL query and returns the result set as a list of maps.
     *
     * @param query the SPARQL query to execute.
     * @return a list of maps containing the variable bindings of the result set.
     */
    List<Map<String, String>> query(String query);

    /**
     * This method runs a SPARQL query on a specific graph and returns the result set.
     *
     * @param query    the SPARQL query to execute.
     * @param graphIRI the IRI of the named graph where the query should be executed.
     * @return a QueryResult object containing the result set of the query.
     */
    QueryResultSet runAQuery(String query, String graphIRI);


    /**
     * This method runs a SPARQL update query on the graph.
     *
     * @param sparqlQuery the SPARQL update query to execute.
     */
    void runAnUpdateQuery(String sparqlQuery);

    /**
     * This method runs a SPARQL update query on a specific graph of the graph.
     *
     * @param sparqlQuery the SPARQL update query to execute.
     * @param m           the graph where the update query should be executed.
     */
    void runAnUpdateQuery(String sparqlQuery, Graph m);

    /**
     * This method retrieves a graph containing all resources (IRIs and literals) that are directly or indirectly connected
     * to the resource with the given IRI, in the specified source and URI.
     *
     * @param id  the id of the source where the resource is located.
     * @param uri the URI of the resource to get the integrated graph for.
     * @return the integrated graph of the resource.
     */
    Graph getIntegratedResourcesOfSource(String id, String uri);

    /**
     * This method simplifies a graph by removing all blank nodes that do not have any outgoing properties.
     *
     * @param m the graph to simplify.
     * @return the simplified graph.
     */
    Graph simplify(Graph m);

    /**
     * This method returns a graph containing all properties that are the same as any of the properties in the input graph.
     *
     * @param graph the input graph.
     * @return the graph containing all sameAs properties.
     */
    Graph getPropertiesSameAs(Graph graph);

    /**
     * This method retrieves a subgraph of a given graph, containing only the resources with the given IRIs and their
     * immediate neighbors.
     *
     * @param resources a list of IRIs of the resources to include in the subgraph.
     * @param uri       the URI of the graph to retrieve the subgraph from.
     * @return the subgraph containing the specified resources and their immediate neighbors.
     */
    Graph getSubGraph(List<String> resources, String uri);

    /**
     * This method closes the RDF graph and releases all resources.
     */
    void closeGraph();
}


