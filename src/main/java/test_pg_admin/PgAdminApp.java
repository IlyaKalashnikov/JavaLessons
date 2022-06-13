package test_pg_admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PgAdminApp {
    public static void main(String[] args) throws SQLException {
        getDriver();
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        try {
        int result = statement.executeUpdate("INSERT INTO test VALUES ('environment', 753)");
            System.out.println("Insert success");
            System.out.println(result + "lines inserted");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
        connection.close();
    }

    private static void getDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Success");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed");
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() {
        Connection connection;
        String dbUrl = System.getenv("DB_URL") + System.getenv("DB_USER&PASS");
        try {
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

