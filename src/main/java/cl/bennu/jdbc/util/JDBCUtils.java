package cl.bennu.jdbc.util;

import cl.bennu.jdbc.dto.ConnectionData;
import cl.bennu.jdbc.enums.DriverEnum;
import cl.bennu.jdbc.exception.ConnectionException;
import cl.bennu.jdbc.exception.DriverException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    public static Connection getConnection(DriverEnum driverEnum, ConnectionData connectionData) throws DriverException, ConnectionException {
        Connection connection = null;

        try {
            if (driverEnum.equals(DriverEnum.MYSQL)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Class.forName("com.mysql.jdbc.Driver");
                // url : jdbc:mysql://localhost/EMP
            } else if (driverEnum.equals(DriverEnum.POSTGRESQL)) {
                Class.forName("org.postgresql.Driver");
                //url : jdbc:postgresql://hostname:port/dbname
            }

            connection = DriverManager.getConnection(connectionData.getUrl(), connectionData.getUser(), connectionData.getPass());
        } catch (ClassNotFoundException e) {
            throw new DriverException();
        } catch (SQLException e) {
            throw new ConnectionException();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
