package edu.upc.essi.dtim.NextiaCore.graph.jena;

import edu.upc.essi.dtim.NextiaCore.graph.Graph;
import lombok.Getter;
import lombok.Setter;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.rdf.model.impl.ResourceImpl;

import java.util.*;
@Getter
@Setter
public class GraphJenaImpl implements Graph {
	Model graph;
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

}