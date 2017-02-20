package cl.bennu.jdbc.builder;

import cl.bennu.jdbc.dto.ConnectionData;

public class JDBCBuilder {

    public static ConnectionData buildConnectionData() {
        ConnectionData connectionData = new ConnectionData();
        connectionData.setUser("root");
        connectionData.setPass("11042.");
        connectionData.setUrl("jdbc:mysql://localhost/calculadora");

        //url : jdbc:mysql://localhost/EMP
        //url : jdbc:postgresql://hostname:port/dbname
        return connectionData;
    }

}
