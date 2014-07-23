package org.gephi.io.database.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wei Wu
 */
public class OracleDBDriver implements SQLDriver {

    public Connection getConnection(String connectionUrl, String username, String passwd) throws SQLException {
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
        Connection connection = null;
        try {
                connection = DriverManager.getConnection(connectionUrl, username, passwd);

        } catch (SQLException e) {
         
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public String getPrefix() {
        return "oracle:thin";
    }

    @Override
    public String toString() {
        return "OracleDB";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OracleDBDriver) {
            return ((OracleDBDriver) obj).getPrefix().equals(getPrefix());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrefix().hashCode();
    }
}
