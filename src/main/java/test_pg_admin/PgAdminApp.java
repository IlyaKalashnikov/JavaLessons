package test_pg_admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgAdminApp {
    public static void main(String[] args) {
        getDriver();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
}

