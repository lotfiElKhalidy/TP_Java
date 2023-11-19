import weather.WeatherInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    private static final String API_KEY = "74b0194008b56de27687486cd366d4c0";
    private static final String GET_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getUrl() {
        return GET_URL;
    }

    public static WeatherInfo getWeatherInfoFromApi(URL url) {
        HttpURLConnection urlConnection = null;
        WeatherInfo weatherInfo = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Parser p = new Parser();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                weatherInfo = p.getWeatherInfoFromJsonFile(in);
            } else {
                if (responseCode >= 400 && responseCode < 500)
                    System.out.println("Error client");

                if (responseCode >= 500)
                    System.out.println("Error server");

                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
                System.out.println(br.readLine());
            }
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if ( urlConnection != null ){
                urlConnection.disconnect();
            }
        }

        return weatherInfo;
    }
}