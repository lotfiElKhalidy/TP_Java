import com.google.gson.Gson;
import weather.WeatherInfo;
import java.io.BufferedReader;

public class Parser {

    //This method gets the Json file (in BufferedReader) and parses it into a WeatherInfo object
    public WeatherInfo getWeatherInfoFromJsonFile(BufferedReader br) {
        WeatherInfo weatherInfo = null;
        Gson gson = new Gson ();

        weatherInfo = gson.fromJson(br, WeatherInfo.class);

        return weatherInfo;
    }
}
