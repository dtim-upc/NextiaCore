package edu.upc.essi.dtim;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.impl.LiteralImpl;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.sparql.core.DatasetImpl;
import org.apache.jena.sparql.core.Transactional;
import org.apache.jena.sys.JenaSystem;
import org.apache.jena.system.Txn;
import org.apache.jena.tdb.TDB;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.vocabulary.RDFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TripleStore extends DatasetImpl {

//
//    static { JenaSystem.init(); }
//    /** Create a TripleStore around a DatasetGraphTDB */
//    public static TripleStore wrap(Dataset datasetGraph) {
//        return new TripleStore((DatasetGraph) datasetGraph) ;
//    }
//    public static TripleStore createTripleStore(String dir)
//    { return TripleStore.wrap(TDBFactory.createDataset(dir) ) ; }
//
//
    protected TripleStore(DatasetGraph dsg) {
        super(dsg);
    }
//
//    protected TripleStore(DatasetGraph dsg, Transactional transactional) {
//        super(dsg, transactional);
//    }
//
//    public TripleStore(GraphDeprecated model) {
//        super(model);
//    }
//
//    public GraphDeprecated getGraph(String iri){
//        return Txn.calculateRead(this, ()-> {
//            if(this.containsNamedModel(iri)){
//                Model m = this.getNamedModel(iri);
//                GraphDeprecated g = GraphDeprecated.createDefaultGraph();
//                g.add(m);
//                return g;
//            }
//            return null;
//        });
//    }
//
//    public Boolean containsGraph(String iri){
//        return Txn.calculateRead(this, ()-> {
//            return this.containsNamedModel(iri);
//        });
//    }
//
//    public void addModel(String namedGraph, Model model){
//        Txn.executeWrite(this, ()-> {
//            Model graph = this.getNamedModel(namedGraph);
//            graph.add(model);
//        });
//    }
//
////    maybe can be call as addNamedModel and delete the above function?
//    public void addModel(String namedGraph, GraphDeprecated model){
//        addModel(namedGraph, (Model) model);
//    }
//
//
//    public void addTriple(String namedGraph, String s, String p, String o) {
//        Txn.executeWrite(this, ()-> {
//            Model graph = this.getNamedModel(namedGraph);
//            graph.add(new ResourceImpl(s), new PropertyImpl(p), new ResourceImpl(o));
//        });
//    }
//
//    public void addTripleLiteral(String namedGraph, String s, String p, String o) {
//        Txn.executeWrite(this, ()-> {
//            Model graph = this.getNamedModel(namedGraph);
//            graph.add(new ResourceImpl(s), new PropertyImpl(p), o);
//        });
//    }
//    public String getDomainOfProperty(String graphIRI, String propertyIRI) {
//        String query = " SELECT ?domain WHERE { GRAPH <" + graphIRI + "> " +
//                " { <"+propertyIRI+"> <"+ RDFS.domain.toString()+"> ?domain. } } ";
//
//        ResultSet res = runAQuery(query);
//
//        if(res.hasNext()){
//            QuerySolution r = res.next();
//            return r.get("domain").toString();
//        }
//        return null;
//    }
//
//    public String getRDFSLabel(String graphIRI, String resourceIRI) {
//        String query = " SELECT ?label WHERE { GRAPH <" + graphIRI + "> " +
//                " { <"+resourceIRI+"> <"+ RDFS.label.toString()+"> ?label. } } ";
//
//        ResultSet res = runAQuery(query);
//
//        if(res.hasNext()){
//            QuerySolution r = res.next();
//            return r.get("label").toString();
//        }
//        return null;
//    }
//
//    public void deleteTriplesWithSubject(String graphIRI, String subjectIRI){
//        runAnUpdateQuery("DELETE WHERE { GRAPH <" + graphIRI + ">" +
//                " {<"+subjectIRI+"> ?p ?o} }");
//    }
//
//    public void deleteTriplesWithObject(String graphIRI, String objectIRI){
//        runAnUpdateQuery("DELETE WHERE { GRAPH <" + graphIRI + ">" +
//                " {?s ?p <"+objectIRI+"> } }");
//    }
//
//    public void deleteTriples(String graphIRI, String subjectIRI, String predicateIRI,  String objectIRI){
//        runAnUpdateQuery("DELETE WHERE { GRAPH <" + graphIRI + ">" +
//                " {<"+subjectIRI+"> <"+predicateIRI+"> <"+objectIRI+"> } }");
//    }
//
//    public void deleteGraph(String iri){
//        Txn.executeWrite(this, ()-> {
//            this.removeNamedModel(iri);
//        });
//    }
//
//    public void deleteAllGraphs(){
//        try {
//            Txn.executeWrite(this, ()-> {
//                Iterator<String> graphNames = this.listNames();
//                List<String> graphs = new ArrayList<>();
//                while (graphNames.hasNext()) {
//                    graphs.add(graphNames.next());
//                }
//                graphs.forEach(iri -> this.removeNamedModel(iri));
//            }) ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateLiteral(String graphIRI, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral){
//        // Look and update triples where oldIRI is object.
////        runAnUpdateQuery("DELETE {  <"+subjectIRI+">  <"+predicateIRI+"> "+oldLiteral+" } " +
////                "INSERT {  <"+subjectIRI+">  <"+predicateIRI+"> "+newLiteral+"} WHERE {  <"+subjectIRI+">  <"+predicateIRI+"> "+oldLiteral+" }");
//
//
//        Txn.executeWrite(this, ()-> {
//            Model graph = this.getNamedModel(graphIRI);
//            if(graph.contains(new ResourceImpl(subjectIRI), new PropertyImpl(predicateIRI), new LiteralImpl( NodeFactory.createLiteral(oldLiteral) ,null))){
//                graph.remove(new ResourceImpl(subjectIRI), new PropertyImpl(predicateIRI), new LiteralImpl( NodeFactory.createLiteral(oldLiteral), null ));
//                graph.add(new ResourceImpl(subjectIRI), new PropertyImpl(predicateIRI), newLiteral);
//            }
//
//        });
//
//    }
//
////    This update it globally in all the dataset (i.e., all named graphs)
//    public void updateLiteral(String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral){
//        // Look and update triples where oldIRI is object.
//        runAnUpdateQuery("DELETE {  <"+subjectIRI+">  <"+predicateIRI+"> '"+oldLiteral+"' } " +
//                "INSERT {  <"+subjectIRI+">  <"+predicateIRI+"> '"+newLiteral+"'} WHERE {  <"+subjectIRI+">  <"+predicateIRI+"> '"+oldLiteral+"' }");
//
//    }
//
//    /*
//     * QUERIES
//     * */
//
//    public ResultSet runAQuery(Query query) {
//
//        ResultSet resultSet = Txn.calculateRead(this, ()-> {
//            try(QueryExecution qExec = QueryExecutionFactory.create(query, this)) {
//                qExec.getContext().set(TDB.symUnionDefaultGraph, true);
//                return ResultSetFactory.copyResults(qExec.execSelect()) ;
//            } catch ( Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }) ;
//        return resultSet;
//    }
//
//    public ResultSet runAQuery(Query query, GraphDeprecated m) {
//        return runAQuery(query, m);
//    }
//
//    public ResultSet runAQuery(Query query, Model m) {
//        try(QueryExecution qExec = QueryExecutionFactory.create(query, m)) {
//            qExec.getContext().set(TDB.symUnionDefaultGraph, true);
//            return ResultSetFactory.copyResults(qExec.execSelect()) ;
//        } catch ( Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ResultSet runAQuery(String query) {
//        return runAQuery(QueryFactory.create(query));
//    }
//
//    public ResultSet runAQuery(String query, GraphDeprecated m) {
//        return runAQuery(query, (Model) m);
//    }
//
//    public ResultSet runAQuery(String query, Model m) {
//        return runAQuery(QueryFactory.create(query),  m);
//    }
//
//
//    public  void runAnUpdateQuery(String sparqlQuery) {
//        Txn.executeWrite(this, ()->{
//            UpdateAction.parseExecute(sparqlQuery, this);
//        });
//    }
//
//    public  void runAnUpdateQuery(String sparqlQuery, GraphDeprecated m) {
//
//        runAnUpdateQuery(sparqlQuery, (Model) m);
//
//    }
//
//    public  void runAnUpdateQuery(String sparqlQuery, Model m) {
//
//        Txn.executeWrite(this, ()->{
//            UpdateAction.parseExecute(sparqlQuery, m);
//        });
//
//    }
}
