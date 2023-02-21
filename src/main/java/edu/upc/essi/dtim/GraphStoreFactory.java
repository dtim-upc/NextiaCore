package edu.upc.essi.dtim;

public class GraphStoreFactory {
    private static GraphStoreInterface instance = null;

    private GraphStoreFactory() {
        // Being private prevents the factory from being instantiated from outside the class
    }

    public static synchronized GraphStoreInterface getInstance() {
        if (instance == null) {
            instance = new GraphStoreJenaImpl();
        }
        return instance;
    }
}
