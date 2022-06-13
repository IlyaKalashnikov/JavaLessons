package networking.repository;

import networking.model.weather_entity.WeatherEntity;

import java.sql.*;

public class DbWeatherRepository {

    public void saveForecast (WeatherEntity entity){
        Connection dbConnection = getConnection();
        PreparedStatement forecastPrepStmt = getPreparedStatement(entity, dbConnection);
        int result = 0;
        try {
            result = forecastPrepStmt.executeUpdate();
            dbConnection.commit();
        } catch (SQLException e){
            try {
                dbConnection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println("Successful INSERT \n" + result + " lines inserted");
        try {
            dbConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement getPreparedStatement(WeatherEntity entity, Connection dbConnection) {
        String preparedStatement = "INSERT INTO accu_weather_forecasts " +
                "(name,id,date,forecast,minimum_temperature,maximum_temperature) VALUES (?,?,?,?,?,?)";
        PreparedStatement forecastPrepStmt = null;
        try {
            forecastPrepStmt = dbConnection.prepareStatement(preparedStatement);
            forecastPrepStmt.setString(1, entity.getLocationName());
            forecastPrepStmt.setString(2, entity.getLocationId());
            forecastPrepStmt.setString(3, entity.getDate());
            forecastPrepStmt.setString(4, entity.getMainForecast());
            forecastPrepStmt.setDouble(5, entity.getMinTemp());
            forecastPrepStmt.setDouble(6, entity.getMaxTemp());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return forecastPrepStmt;
    }

    private void downloadDbmsDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Downloaded DBMS driver successfully");
    }

    private Connection getConnection() {
        downloadDbmsDriver();
        String dbUrl = System.getenv("DB_URL") + System.getenv("DB_USER&PASS");
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(dbUrl);
            dbConnection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to Database successfully");
        return dbConnection;
    }
}
