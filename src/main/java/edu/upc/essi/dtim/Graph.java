package edu.upc.essi.dtim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A class that represents a graph data structure, where the nodes are represented by instances of the Node class and the
 * edges are represented by instances of the Edge class.
 */
public class Graph {

    // A map that associates each node URI with its corresponding Node object.
    private final Map<String, Node> nodes = new HashMap<>();

    /**
     * Constructs a new instance of the Graph class.
     */
    public Graph() {
    }

    /**
     * Adds a new triple to the graph, represented by the given subject, predicate, and object URIs.
     *
     * @param subject   the URI of the subject node.
     * @param predicate the URI of the predicate node.
     * @param object    the URI of the object node.
     */
    public void addTriple(String subject, String predicate, String object) {
        // Retrieves or creates the nodes corresponding to the subject, predicate, and object URIs.
        Node s = getOrCreateNode(subject);
        Node p = getOrCreateNode(predicate);
        Node o = getOrCreateNode(object);

        // Adds an outgoing edge from the subject node to the object node, labeled with the predicate node.
        s.addOutgoingEdge(p, o);

        // Adds an incoming edge to the object node from the subject node, labeled with the predicate node.
        o.addIncomingEdge(p, s);
    }


    /**
     * Returns a set of nodes in the graph that have the specified URI.
     *
     * @param uri the URI to search for.
     * @return a set of nodes in the graph that have the specified URI.
     */
    public Set<Node> getNodesByUri(String uri) {
        Set<Node> result = new HashSet<>();

        for (Node node : nodes.values()) {
            if (node.getUri().equals(uri)) {
                result.add(node);
            }
        }

        return result;
    }

    /**
     * Returns a set of all the edges in the graph.
     *
     * @return a set of all the edges in the graph.
     */
    public Set<Edge> getEdges() {
        Set<Edge> result = new HashSet<>();

        for (Node node : nodes.values()) {
            for (Map.Entry<Node, Set<Node>> entry : node.getOutgoingEdges().entrySet()) {
                Node predicate = entry.getKey();
                for (Node object : entry.getValue()) {
                    result.add(new Edge(node, predicate, object));
                }
            }
        }

        return result;
    }

    /**
     * Retrieves the node corresponding to the given URI from the graph, or creates a new node with the given URI if it
     * does not already exist.
     *
     * @param uri the URI of the node to retrieve or create.
     * @return the node corresponding to the given URI.
     */
    private Node getOrCreateNode(String uri) {
        Node node = nodes.get(uri);

        if (node == null) {
            node = new Node(uri);
            nodes.put(uri, node);
        }

        return node;
    }

    /**
     * A class that represents a node in a graph data structure. Each node is identified by a unique URI and can have outgoing and incoming edges
     * to other nodes in the graph.
     */
    public static class Node {
        private final String uri;
        private final Map<Node, Set<Node>> outgoingEdges = new HashMap<>();
        private final Map<Node, Set<Node>> incomingEdges = new HashMap<>();

        /**
         * Constructs a new instance of the Node class with the given URI.
         *
         * @param uri the URI that uniquely identifies the node.
         */
        public Node(String uri) {
            this.uri = uri;
        }

        /**
         * Returns the URI of the node.
         *
         * @return the URI of the node.
         */
        public String getUri() {
            return uri;
        }

        /**
         * Returns a map of outgoing edges from the node, where each key is a predicate node and each value is a set of object nodes.
         *
         * @return a map of outgoing edges from the node.
         */
        public Map<Node, Set<Node>> getOutgoingEdges() {
            return outgoingEdges;
        }

        /**
         * Returns a map of incoming edges to the node, where each key is a predicate node and each value is a set of subject nodes.
         *
         * @return a map of incoming edges to the node.
         */
        public Map<Node, Set<Node>> getIncomingEdges() {
            return incomingEdges;
        }

        /**
         * Adds a new outgoing edge from the node to the given object node, labeled with the given predicate node.
         *
         * @param predicate the predicate node that labels the edge.
         * @param object    the object node that the edge points to.
         */
        public void addOutgoingEdge(Node predicate, Node object) {
            outgoingEdges.computeIfAbsent(predicate, k -> new HashSet<>()).add(object);
        }

        /**
         * Adds a new incoming edge to the node from the given subject node, labeled with the given predicate node.
         *
         * @param predicate the predicate node that labels the edge.
         * @param subject   the subject node that the edge points from.
         */
        public void addIncomingEdge(Node predicate, Node subject) {
            incomingEdges.computeIfAbsent(predicate, k -> new HashSet<>()).add(subject);
        }
    }

    /**
     * A class representing an edge in a graph data structure, connecting a subject node to an object node via a predicate node.
     */
    public static class Edge {
        // The subject node of the edge.
        private final Node subject;
        // The predicate node labeling the edge.
        private final Node predicate;
        // The object node of the edge.
        private final Node object;

        /**
         * Constructs a new instance of the Edge class.
         *
         * @param subject   the subject node of the edge.
         * @param predicate the predicate node labeling the edge.
         * @param object    the object node of the edge.
         */
        public Edge(Node subject, Node predicate, Node object) {
            this.subject = subject;
            this.predicate = predicate;
            this.object = object;
        }

        /**
         * Returns the subject node of the edge.
         *
         * @return the subject node.
         */
        public Node getSubject() {
            return subject;
        }

        /**
         * Returns the predicate node labeling the edge.
         *
         * @return the predicate node.
         */
        public Node getPredicate() {
            return predicate;
        }

        /**
         * Returns the object node of the edge.
         *
         * @return the object node.
         */
        public Node getObject() {
            return object;
        }
    }
}

