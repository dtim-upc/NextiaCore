package edu.upc.essi.dtim;

public class GraphStoreFactory {
    private static GraphStoreInterface instance = null;

    private GraphStoreFactory() {
        // Al ser private se evita que se instancie la factoría desde fuera de la clase
    }

    public static synchronized GraphStoreInterface getInstance() {
        if (instance == null) {
            instance = new GraphStoreJenaImpl();
        }
        return instance;
    }
}
