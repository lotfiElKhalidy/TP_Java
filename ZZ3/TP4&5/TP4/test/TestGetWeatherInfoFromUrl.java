import junit.framework.TestCase;
import weather.WeatherInfo;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestGetWeatherInfoFromUrl extends TestCase {
    public void testNominalCase() {
        String city_name = "Clermont-Ferrand";
        WeatherInfo weatherInfo = null;

        try {
            URI url = new URI(String.format(Api.getUrl(), city_name, Api.getApiKey()));
            weatherInfo = Api.getWeatherInfoFromApi(url.toURL());
        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error : " + e.getMessage());
        }

        assertNotNull(weatherInfo);
        assertEquals("Arrondissement de Clermont-Ferrand", weatherInfo.name);
        assertEquals(200, weatherInfo.cod);
    }

    public void testErrorClientCase() {
        String city_name = "Clermont Ferrand";
        WeatherInfo weatherInfo = null;

        try {
            URI url = new URI(String.format(Api.getUrl(), city_name, Api.getApiKey()));
            weatherInfo = Api.getWeatherInfoFromApi(url.toURL());
        }
        catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Malformed exception ::::: " + e.getMessage());
        }

        assertNull(weatherInfo);
    }

    public void testMalformedUrlCase() {
        String city_name = "Clermont Ferrand";
        WeatherInfo weatherInfo = null;

        try {
            URI url = new URI(String.format(Api.getUrl(), city_name, Api.getApiKey()));
            weatherInfo = Api.getWeatherInfoFromApi(url.toURL());
        }
        catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Malformed exception ::::: " + e.getMessage());
        }

        assertNull(weatherInfo);
    }
}
