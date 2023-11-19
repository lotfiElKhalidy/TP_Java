package weather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherInfo {
    public ArrayList<Weather> weather;

    @SerializedName("main")
    public MainInfo mainInfo;

    public int id;

    public String name;

    public int cod;

    public WeatherInfo() {
        mainInfo = new MainInfo();
    }

    @Override
    public String toString() {
        return "WeatherInfo { weather=" + weather +
                ", mainInfo=" + mainInfo +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}