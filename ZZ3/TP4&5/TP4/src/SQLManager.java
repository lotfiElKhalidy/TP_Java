import weather.WeatherInfo;

import java.sql.*;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class SQLManager {
    private static final String URL = "jdbc:sqlite:weather.db";

    public static void initialiseDatabase() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Weather (" +
                    " city VARCHAR(255) NOT NULL," +
                    " temperature REAL NOT NULL, " +
                    " requestDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception ::: " + e.getMessage());
        }
    }

    public static void insertWeatherData(String city_name, double temperature) {
        try {
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO Weather (city, temperature) VALUES (?, ?)");

            insertStatement.setString(1, city_name);
            insertStatement.setDouble(2, temperature);
            insertStatement.executeUpdate();

            insertStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception ::: " + e.getMessage());
        }
    }

    public static void updateWeatherData(String city_name, double newTemperature, Timestamp newRequestDate) {
        try {
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement insertStatement = connection.prepareStatement(
                    "UPDATE weather SET temperature = ?, requestDate = ? WHERE city = ?");

            // There is a difference of 1 hour between the time set in the database and the current time
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(newRequestDate.getTime());
            calendar.add(Calendar.HOUR, -1);
            newRequestDate = new Timestamp(calendar.getTimeInMillis());

            insertStatement.setDouble(1, newTemperature);
            insertStatement.setTimestamp(2, newRequestDate);
            insertStatement.setString(3, city_name);
            int count = insertStatement.executeUpdate();

            insertStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception ::: " + e.getMessage());
        }
    }

    public static WeatherInfo getWeatherDataByCityName(String city_name) {
        WeatherInfo weatherInfo = null;

        try {
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Weather WHERE city = ?");

            selectStatement.setString(1, city_name);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                weatherInfo = new WeatherInfo();
                weatherInfo.name = resultSet.getString("city");
                weatherInfo.mainInfo.temp = resultSet.getDouble("temperature");
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception ::: " + e.getMessage());
        }

        return weatherInfo;
    }

    public static boolean isDataValid(String city_name) {
        boolean isDataValid = false;

        try {
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement selectStatement = connection.prepareStatement("SELECT requestDate FROM Weather WHERE city = ?");

            selectStatement.setString(1, city_name);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                Timestamp requestDate = resultSet.getTimestamp("requestDate");

                // There is a difference of 1 hour between the time set in the database and the current time
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(requestDate.getTime());
                calendar.add(Calendar.HOUR, 1);
                requestDate = new Timestamp(calendar.getTimeInMillis());

                long differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(currentTime.getTime() - requestDate.getTime());

                if (differenceInMinutes < 10)
                    isDataValid = true;
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception ::: " + e.getMessage());
        }

        return isDataValid;
    }

    public static void displayAllWeatherData() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            Statement selectStatement = connection.createStatement();

            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM Weather ORDER BY city, temperature");

            while (resultSet.next()) {
                System.out.println("city : " + resultSet.getString("city") +
                        ", Température : " + resultSet.getDouble("temperature") +
                        ", Timestamp : " + resultSet.getTimestamp("requestDate"));
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL exception :::" + e.getMessage());
        }
    }
}
