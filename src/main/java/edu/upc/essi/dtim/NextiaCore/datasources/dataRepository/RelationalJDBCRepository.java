package edu.upc.essi.dtim.NextiaCore.datasources.dataRepository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RelationalJDBCRepository extends DataRepository{
    String username;
    String password;
    String port;

    public RelationalJDBCRepository() {
    }

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

    public boolean testConnection() {
        try {
            Connection conexion = DriverManager.getConnection(port, username, password);
            conexion.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
