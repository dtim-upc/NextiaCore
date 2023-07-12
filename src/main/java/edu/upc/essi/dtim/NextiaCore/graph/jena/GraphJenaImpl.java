package edu.upc.essi.dtim.NextiaCore.graph.jena;

import edu.upc.essi.dtim.NextiaCore.graph.Graph;
import lombok.Getter;
import lombok.Setter;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class GraphJenaImpl implements Graph {
	public Model getGraph() {
		return graph;
	}

	public void setGraph(Model graph) {
		this.graph = graph;
	}

	Model graph;

	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}

	String graphName;
	private String graphicalSchema;

	@Override
	public String getGraphicalSchema() {
		return graphicalSchema;
	}

	@Override
	public void setGraphicalSchema(String graphicalSchema) {
		this.graphicalSchema = graphicalSchema;
	}

	/**
	 * Constructor to initialize the graph with a name and set of triples
	 *
	 * @param name     the name of the graph
	 * @param triples  the set of triples to be stored in the graph
	 */
	public GraphJenaImpl(String id, String name, Model triples) {
		graph = ModelFactory.createDefaultModel();
		graphName = "http://example/"+ UUID.randomUUID().toString();
	}

	public GraphJenaImpl(String graphName){
		graph = ModelFactory.createDefaultModel();
		this.graphName = graphName;
	}

	public GraphJenaImpl() {
		graph = ModelFactory.createDefaultModel();
		graphName = "http://example/"+ UUID.randomUUID().toString();
	}

	@Override
	public String getGraphName() {
		return graphName;
	}

	@Override
	public void addTriple(String subject, String predicate, String object) {
		Resource r = graph.createResource(subject);
		r.addProperty(graph.createProperty(predicate), graph.createResource(object));
	}

	@Override
	public void addTripleLiteral(String subject, String predicate, String literal) {
		Resource r = graph.createResource(subject);
		r.addProperty(graph.createProperty(predicate), literal);
	}

	@Override
	public void deleteTriple(String subject, String predicate, String object) {
		graph.removeAll(new ResourceImpl(subject), new PropertyImpl(predicate), new ResourceImpl(object));
	}

	@Override
	public List<Map<String, Object>> query(String sparql) {
		List<Map<String, Object>> resultsList = new ArrayList<>();

		try (QueryExecution qExec = QueryExecutionFactory.create(QueryFactory.create(sparql), graph)) {
			ResultSetRewindable results = ResultSetFactory.copyResults(qExec.execSelect());
			qExec.close();

			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				Map<String, Object> row = new HashMap<>();

				for (String var : results.getResultVars()) {
					RDFNode node = soln.get(var);

					// Convert RDFNode to a more general data type if possible
					if (node.isLiteral()) {
						row.put(var, node.asLiteral().getValue());
					} else if (node.isResource()) {
						row.put(var, node.asResource().getURI());
					} else {
						row.put(var, node.toString());
					}
				}
				resultsList.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultsList;
	}

	@Override
	public ResIterator getSubjects() {
		List<String> subjects = new ArrayList<>();

		ResIterator iter = graph.listSubjects();
		return iter;
		/*while (iter.hasNext()) {
			Resource resource = iter.nextResource();
			subjects.add(resource.getURI());
		}

		return subjects;*/
	}

	@Override
	public List<String> getPredicates() {
		List<String> predicates = new ArrayList<>();

		StmtIterator iter = graph.listStatements();
		while (iter.hasNext()) {
			Statement statement = iter.nextStatement();
			Property property = statement.getPredicate();
			predicates.add(property.getURI());
		}

		return predicates;
	}

	@Override
	public void write(String file) {
		try {
			RDFDataMgr.write(new FileOutputStream(file), graph, Lang.TURTLE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//todo delete when bootsrapp is done
	@Override
	public void setModel(Model model){
		this.graph = model;
	}

}