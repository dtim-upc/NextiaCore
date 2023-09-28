package edu.upc.essi.dtim.NextiaCore.datasources.dataRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RelationalJDBCRepository extends DataRepository{

    public RelationalJDBCRepository() {
    }

    String username;
    String password;
    String port;

    public RelationalJDBCRepository(String username, String password, String port) {
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean testConnection(){
        try {
            Connection conexion = DriverManager.getConnection(port, username, password);
            System.out.println("¡Conexión exitosa!"); // Si llegas aquí, las credenciales son correctas
            conexion.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            return false;
        }
    }

    boolean testConnection(String url, String user, String password){
        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa!"); // Si llegas aquí, las credenciales son correctas
            conexion.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            return false;
        }
    }
}
