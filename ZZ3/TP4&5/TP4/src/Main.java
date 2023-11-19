import weather.WeatherInfo;
import java.net.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome! Today, we're going to talk about the weather.");
        System.out.println("________");

        SQLManager.initialiseDatabase(); // Create the database locally (if not done previously)

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("________");
            System.out.println("Specify the name of a city :");
            System.out.println("-.- To quit, type Q.");
            System.out.println("-.- To display all the info available on the local db, type D.");
            System.out.println("________");

            String city_name = scanner.nextLine();

            if (city_name.equals("Q") || city_name.equals("q")) {
                System.out.println("See you soon !");
                exit = true;
            } else if (city_name.equals("D") || city_name.equals("d")) {
                System.out.println("------------------------------------");
                SQLManager.displayAllWeatherData();
            } else {
                WeatherInfo weatherInfo = SQLManager.getWeatherDataByCityName(city_name);
                boolean shouldUpdateData = false;

                // 1st case : The data is still valid and we can reuse it
                if (weatherInfo != null) {
                    if (SQLManager.isDataValid(city_name)) {
                        displayWeatherInfoInConsole(weatherInfo);
                    } else {
                        // 2nd case : The data is not valid in the db and should be updated
                        insertOrUpdateWeatherInfo(city_name, true);
                    }
                } else {
                    // 3rd case : The data doesn't exist in the db and should be inserted
                    insertOrUpdateWeatherInfo(city_name, false);
                }
            }
        }
    }

    public static void insertOrUpdateWeatherInfo(String city_name, boolean shouldUpdateData) {
        try {
            URI url = new URI(String.format(Api.getUrl(), city_name, Api.getApiKey()));
            WeatherInfo weatherInfo = Api.getWeatherInfoFromApi(url.toURL());

            if (weatherInfo != null) {
                displayWeatherInfoInConsole(weatherInfo);

                if (shouldUpdateData) {
                    SQLManager.updateWeatherData(city_name, weatherInfo.mainInfo.temp, new Timestamp(System.currentTimeMillis()));
                } else {
                    SQLManager.insertWeatherData(city_name, weatherInfo.mainInfo.temp);
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("Error: The given URL is malformed");
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("Error : The given city name is invalid !!");
            System.out.println(e.getMessage());
        }
    }

    public static void displayWeatherInfoInConsole(WeatherInfo weatherInfo) {
        System.out.println("------------------------------------");
        System.out.println("Here is the result for " + weatherInfo.name);
        System.out.println("The temperature is " + weatherInfo.mainInfo.temp);
    }
}