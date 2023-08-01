package edu.upc.essi.dtim.NextiaCore.datasources.dataRepository;

public class RelationalDBRepository extends DataRepository{

    public RelationalDBRepository() {
    }

    String username;
    String password;
    String port;

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
}
