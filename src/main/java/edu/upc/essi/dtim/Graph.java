package edu.upc.essi.dtim;

import org.apache.jena.enhanced.Personality;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdf.model.impl.ModelCom;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sys.JenaSystem;
import org.apache.jena.update.UpdateAction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Graph extends ModelCom {

    static { JenaSystem.init(); }

    public static Graph createDefaultGraph()
    { return new Graph( org.apache.jena.graph.Factory.createGraphMem( ) ); }

    public static Graph wrap(Model g){
        return new Graph(g.getGraph());
    }

    public Graph(org.apache.jena.graph.Graph base) {
        super(base);
    }

    public Graph(org.apache.jena.graph.Graph base, Personality<RDFNode> personality) {
        super(base, personality);
    }

    public Graph union( Graph model ) {
        return wrap( this.union(model));
    }
//    public Graph union( Model model ) {
//        return wrap( this.union(model));
//    }

    public void add(String subject, String predicate, String object) {
        Resource r = createResource(subject);
        r.addProperty(createProperty(predicate), createResource(object));
    }
    public void add(String subject, Property predicate, Resource object) {
        Resource r = createResource(subject);
        r.addProperty(predicate, object);
    }

    public void add(String subject, Property predicate, String object) {
        Resource r = createResource(subject);
        r.addProperty(predicate, createResource(object));
    }


    public void addLiteral(String subject, String predicate, String literal) {
        Resource r = createResource(subject);
        r.addProperty(createProperty(predicate), literal);
    }

    public void addLiteral(String subject, Property predicate, String literal) {
        Resource r = createResource(subject);
        r.addProperty(predicate, literal);
    }

    public void deleteResource(String uri) {
        deleteSubject(uri);
        deleteObject(uri);
    }

    public void deleteSubject(String uri) {
        Resource r = createResource(uri);
        removeAll(r, null, null);
    }

    public void deleteObject(String uri) {
        Resource r = createResource(uri);
        removeAll(null, null, r);
    }

    public void delete(String subject, String predicate, String object){
        removeAll(new ResourceImpl(subject), new PropertyImpl(predicate), new ResourceImpl(object));
    }

//    TODO: rename to updateResourceIRI?
    /**
     * Delete triple with oldIri and insert new triple with newIri in jena graph
     * @param oldIRI actual iri that appears in the triples.
     * @param newIRI new iri that is going to replace the actual iri.
     */
    public void updateResourceNodeIRI(String oldIRI, String newIRI){
        // Look and update triples where oldIRI is object.
        runAnUpdateQuery("DELETE {?s ?p <"+oldIRI+">} " +
                "INSERT {?s ?p <"+newIRI+">} WHERE {  ?s ?p <"+oldIRI+"> }");
        // Look and update triples where oldIRI is subject.
        runAnUpdateQuery("DELETE {<"+oldIRI+"> ?p ?o} " +
                "INSERT {<"+newIRI+"> ?p ?o} WHERE {  <"+oldIRI+"> ?p ?o }");
    }

    public void updateProperty(String oldIRI, String newIRI){
        // Look and update triples where oldIRI is object.
        runAnUpdateQuery("DELETE {?s ?p <"+oldIRI+">} " +
                "INSERT {?s ?p <"+newIRI+">} WHERE {  ?s ?p <"+oldIRI+"> }");
        // Look and update triples where oldIRI is subject.
        runAnUpdateQuery("DELETE {<"+oldIRI+"> ?p ?o} " +
                "INSERT {<"+newIRI+"> ?p ?o} WHERE {  <"+oldIRI+"> ?p ?o }");
    }

    public  void runAnUpdateQuery(String sparqlQuery) {

        try {
            UpdateAction.parseExecute(sparqlQuery, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet runAQuery(String query) {

        try (QueryExecution qExec = QueryExecutionFactory.create(QueryFactory.create(query), this)) {
            ResultSetRewindable results = ResultSetFactory.copyResults(qExec.execSelect());
            qExec.close();
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    this only works for resources. We need containsliteral method too!!!
    public boolean contains(String subject, String predicate, String object){

        return contains(createResource(subject), createProperty(predicate), createResource(object)  );
    }

    public void loadModel(String path){
        read(path, "TURTLE");
    }

    public void loadModel(String path, String lang){
        read(path, lang);
    }

    public void write(String file, Lang lang) {
        try {
            RDFDataMgr.write(new FileOutputStream(file), this, lang);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String file) {
        try {
            RDFDataMgr.write(new FileOutputStream(file), this, Lang.TURTLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Model m = ModelFactory.createDefaultModel();
        m.add(new ResourceImpl("http://example.com"), new PropertyImpl("http://predicate"), new ResourceImpl("http://pop"));
        Graph m2 = Graph.wrap(m);
        m2.add("http://example2.com","http://predicate2", "http://pop2");

        System.out.println(m2.size());
       Graph model = Graph.createDefaultGraph();
       model.add("http://example.com","http://predicate", "http://pop");

        System.out.println(model.contains("http://example.com","http://predicate", "http://pop"));
    }
}
